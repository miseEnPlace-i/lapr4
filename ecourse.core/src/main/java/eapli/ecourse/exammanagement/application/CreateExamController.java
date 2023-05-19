package eapli.ecourse.exammanagement.application;

import java.io.IOException;

import eapli.ecourse.coursemanagement.application.ListCourseService;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.coursemanagement.dto.CourseDTO;
import eapli.ecourse.coursemanagement.repositories.CourseRepository;
import eapli.ecourse.eventsmanagement.domain.Time;
import eapli.ecourse.exammanagement.application.exceptions.ParseException;
import eapli.ecourse.exammanagement.domain.Exam;
import eapli.ecourse.exammanagement.domain.ExamBuilder;
import eapli.ecourse.exammanagement.domain.parsers.ExamsParser;
import eapli.ecourse.exammanagement.domain.repositories.ExamRepository;
import eapli.ecourse.teachermanagement.domain.Teacher;
import eapli.ecourse.teachermanagement.repositories.TeacherRepository;
import eapli.ecourse.usermanagement.domain.ClientRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

@UseCaseController
public class CreateExamController {
  private final ListCourseService listCourseService;
  private final AuthorizationService authz;
  private final TeacherRepository teacherRepository;
  private final CourseRepository courseRepository;
  private final ExamRepository examRepository;

  private ExamBuilder builder;

  public CreateExamController(final AuthorizationService authz, final TeacherRepository teacherRepository,
      final ExamRepository examRepository, final CourseRepository courseRepository) {
    this.authz = authz;
    this.teacherRepository = teacherRepository;
    this.examRepository = examRepository;
    this.courseRepository = courseRepository;
    this.listCourseService = new ListCourseService(courseRepository);
  }

  public Iterable<CourseDTO> listInProgressCourses() {
    authz.ensureAuthenticatedUserHasAnyOf(ClientRoles.POWER_USER, ClientRoles.TEACHER);
    return listCourseService.listInProgressCourses();
  }

  public void parseExam(final String filePath) throws IOException, ParseException {
    authz.ensureAuthenticatedUserHasAnyOf(ClientRoles.POWER_USER, ClientRoles.TEACHER);
    builder = ExamsParser.parseWithVisitor(filePath);
  }

  public Exam createExam(CourseDTO courseDto, Time startTime, Time endTime) {
    authz.ensureAuthenticatedUserHasAnyOf(ClientRoles.POWER_USER, ClientRoles.TEACHER);
    SystemUser authenticatedUser = authz.loggedinUserWithPermissions(ClientRoles.TEACHER).orElseThrow();

    Teacher teacher = teacherRepository.findByUsername(authenticatedUser.username()).orElseThrow();
    Course course = courseRepository.findByCode(courseDto.getCode()).orElseThrow();

    builder.withTeacher(teacher).withCourse(course).withStartTime(startTime).withEndTime(endTime);

    Exam exam = builder.build();

    return examRepository.save(exam);
  }
}
