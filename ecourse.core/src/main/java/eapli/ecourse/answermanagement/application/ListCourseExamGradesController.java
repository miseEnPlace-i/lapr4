package eapli.ecourse.answermanagement.application;

import java.util.ArrayList;
import java.util.Collection;

import eapli.ecourse.answermanagement.dto.AnswerDTO;
import eapli.ecourse.answermanagement.repositories.AnswerRepository;
import eapli.ecourse.coursemanagement.application.ListCourseService;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.coursemanagement.dto.CourseDTO;
import eapli.ecourse.coursemanagement.repositories.CourseRepository;
import eapli.ecourse.enrolmentmanagement.application.ListEnrolmentService;
import eapli.ecourse.enrolmentmanagement.dto.EnrolmentDTO;
import eapli.ecourse.enrolmentmanagement.repositories.EnrolmentRepository;
import eapli.ecourse.exammanagement.application.EvaluationExamListService;
import eapli.ecourse.exammanagement.dto.EvaluationExamDTO;
import eapli.ecourse.exammanagement.repositories.EvaluationExamRepository;
import eapli.ecourse.studentmanagement.domain.Student;
import eapli.ecourse.studentmanagement.repositories.StudentRepository;
import eapli.ecourse.teachermanagement.domain.Teacher;
import eapli.ecourse.teachermanagement.repositories.TeacherRepository;
import eapli.ecourse.usermanagement.domain.ClientRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

public class ListCourseExamGradesController {
  private final EvaluationExamListService evaluationService;
  private final AuthorizationService authz;
  private final ListCourseService courseService;
  private final TeacherRepository teacherRepository;
  private final ListExamAnswerService answerService;
  private final ListEnrolmentService enrolmentService;
  private final StudentRepository studentRepository;

  public ListCourseExamGradesController(AuthorizationService authz,
      EvaluationExamRepository evaluationRepository, CourseRepository courseRepository,
      TeacherRepository teacherRepository, AnswerRepository answerRepository,
      EnrolmentRepository enrolmentRepository, StudentRepository studentRepository) {
    this.evaluationService = new EvaluationExamListService(evaluationRepository);
    this.authz = authz;
    this.courseService = new ListCourseService(courseRepository);
    this.teacherRepository = teacherRepository;
    this.answerService = new ListExamAnswerService(answerRepository, evaluationRepository);
    this.enrolmentService = new ListEnrolmentService(enrolmentRepository);
    this.studentRepository = studentRepository;
  }

  public Iterable<CourseDTO> teacherCourses() {
    SystemUser user = authz.loggedinUserWithPermissions(ClientRoles.TEACHER).orElseThrow();

    Teacher teacher = teacherRepository.findByUsername(user.username()).orElseThrow();

    return courseService.listInProgressCoursesThatTeacherLectures(teacher);
  }

  public Iterable<EvaluationExamDTO> courseEvaluationExams(CourseDTO course) {
    return evaluationService.listAllPastCourseExams(
        courseService.findCourseByCourseCode(course.getCode()).orElseThrow());
  }

  public Iterable<AnswerDTO> evaluationExamGrades(EvaluationExamDTO examDTO) {
    return answerService.listExamGrades(evaluationService.findExamByCode(
      examDTO.getIdentifier()).orElseThrow(), studentsInCourse(examDTO.getCourse()));
  }

  private Collection<Student> studentsInCourse(Course course) {
    Collection<Student> students = new ArrayList<>();

    Iterable<EnrolmentDTO> enrollments = enrolmentService.listStudentsEnrolled(course.code());

    enrollments.forEach(e -> students
        .add(studentRepository.findByMecanographicNumber(e.getStudentNumber()).orElseThrow()));
    return students;
  }
}
