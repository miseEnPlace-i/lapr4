package eapli.ecourse.exammanagement.application;

import eapli.ecourse.answermanagement.application.ListExamAnswerService;
import eapli.ecourse.answermanagement.dto.ExamAnswerDTO;
import eapli.ecourse.answermanagement.repositories.ExamAnswerRepository;
import eapli.ecourse.coursemanagement.application.ListCourseService;
import eapli.ecourse.coursemanagement.dto.CourseDTO;
import eapli.ecourse.coursemanagement.repositories.CourseRepository;
import eapli.ecourse.exammanagement.dto.EvaluationExamDTO;
import eapli.ecourse.exammanagement.dto.FormativeExamDTO;
import eapli.ecourse.exammanagement.repositories.EvaluationExamRepository;
import eapli.ecourse.exammanagement.repositories.FormativeExamRepository;
import eapli.ecourse.teachermanagement.domain.Teacher;
import eapli.ecourse.teachermanagement.repositories.TeacherRepository;
import eapli.ecourse.usermanagement.domain.ClientRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

public class ListCourseExamGradesController {

  private final EvaluationExamListService evaluationService;

  private final FormativeExamListService formativeService;

  private final AuthorizationService authz;

  private final ListCourseService courseService;

  private final TeacherRepository teacherRepository;

  private final ListExamAnswerService answerService;


  public ListCourseExamGradesController(AuthorizationService authz, EvaluationExamRepository evaluationRepository,
                                        FormativeExamRepository formativeRepository, CourseRepository courseRepository,
                                        TeacherRepository teacherRepository, ExamAnswerRepository answerRepository) {
    this.evaluationService = new EvaluationExamListService(evaluationRepository);
    this.formativeService = new FormativeExamListService(formativeRepository);
    this.authz = authz;
    this.courseService = new ListCourseService(courseRepository);
    this.teacherRepository = teacherRepository;
    this.answerService = new ListExamAnswerService(answerRepository, evaluationRepository, formativeRepository);
  }

  public Iterable<CourseDTO> teacherCourses() {
   SystemUser user =  authz.loggedinUserWithPermissions(ClientRoles.TEACHER).orElseThrow();

   Teacher teacher =  teacherRepository.findByUsername(user.username()).orElseThrow();

   return courseService.listInProgressCoursesThatTeacherLectures(teacher);
  }

  public Iterable<EvaluationExamDTO> courseEvaluationExams(CourseDTO course) {
    return evaluationService.listAllPastCourseExams(courseService.findCourseByCourseCode(course.getCode()).orElseThrow());
  }

  public Iterable<FormativeExamDTO> courseFormativeExams(CourseDTO course) {
    return formativeService.findAllCourseExams(courseService.findCourseByCourseCode(course.getCode()).orElseThrow());
  }

  public Iterable<ExamAnswerDTO> evaluationExamGrades(EvaluationExamDTO examDTO) {
    return answerService.listExamGrades(evaluationService.findExamByCode(examDTO.getCode()).orElseThrow());
  }

  public Iterable<ExamAnswerDTO> formativeExamGrades(FormativeExamDTO examDTO) {
    return answerService.listExamGrades(formativeService.findExamByCode(examDTO.getCode()).orElseThrow());
  }

}