package eapli.ecourse.exammanagement.application;

import java.io.IOException;

import eapli.ecourse.coursemanagement.application.ListCourseService;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.coursemanagement.dto.CourseDTO;
import eapli.ecourse.coursemanagement.repositories.CourseRepository;
import eapli.ecourse.eventsmanagement.domain.Time;
import eapli.ecourse.exammanagement.application.exceptions.ParseException;
import eapli.ecourse.exammanagement.domain.evaluation.EvaluationExam;
import eapli.ecourse.exammanagement.domain.evaluation.EvaluationExamBuilder;
import eapli.ecourse.exammanagement.domain.parsers.ANTLR4ExamParser;
import eapli.ecourse.exammanagement.repositories.EvaluationExamRepository;
import eapli.ecourse.teachermanagement.domain.Teacher;
import eapli.ecourse.teachermanagement.repositories.TeacherRepository;
import eapli.ecourse.usermanagement.domain.ClientRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

@UseCaseController
public class CreateEvaluationExamController {
  private final ListCourseService listCourseService;
  private final AuthorizationService authz;
  private final TeacherRepository teacherRepository;
  private final CourseRepository courseRepository;
  private final EvaluationExamRepository examRepository;
  private final ANTLR4ExamParser parser;

  private Teacher teacher;

  private EvaluationExamBuilder builder;

  public CreateEvaluationExamController(final AuthorizationService authz, final TeacherRepository teacherRepository,
      final EvaluationExamRepository examRepository, final CourseRepository courseRepository) {
    this.authz = authz;
    this.teacherRepository = teacherRepository;
    this.examRepository = examRepository;
    this.courseRepository = courseRepository;
    this.listCourseService = new ListCourseService(courseRepository);
    this.parser = new ANTLR4ExamParser();
  }

  public void setCurrentAuthenticatedTeacher() {
    authz.ensureAuthenticatedUserHasAnyOf(ClientRoles.POWER_USER, ClientRoles.TEACHER);
    SystemUser authenticatedUser = authz.loggedinUserWithPermissions(ClientRoles.TEACHER).orElseThrow();

    teacher = teacherRepository.findByUsername(authenticatedUser.username()).orElseThrow();
  }

  public Iterable<CourseDTO> listInProgressCoursesOfAuthenticatedTeacher() {
    authz.ensureAuthenticatedUserHasAnyOf(ClientRoles.POWER_USER, ClientRoles.TEACHER);
    setCurrentAuthenticatedTeacher();
    return listCourseService.listInProgressCoursesThatTeacherLectures(teacher);
  }

  public void parseExam(final String filePath) throws IOException, ParseException {
    authz.ensureAuthenticatedUserHasAnyOf(ClientRoles.POWER_USER, ClientRoles.TEACHER);
    setCurrentAuthenticatedTeacher();
    builder = parser.parseFromFile(filePath);
  }

  public void createExam(CourseDTO courseDto, Time startTime, Time endTime) {
    authz.ensureAuthenticatedUserHasAnyOf(ClientRoles.POWER_USER, ClientRoles.TEACHER);
    setCurrentAuthenticatedTeacher();
    Course course = courseRepository.ofIdentity(courseDto.getCode()).orElseThrow();

    builder.withTeacher(teacher).withCourse(course).withStartTime(startTime).withEndTime(endTime);

    EvaluationExam exam = builder.build();

    if (examRepository.ofIdentity(exam.identity()).isPresent())
      throw new IllegalStateException("An exam with the same identifier already exists.");

    exam.publish();
    examRepository.save(exam);
  }
}
