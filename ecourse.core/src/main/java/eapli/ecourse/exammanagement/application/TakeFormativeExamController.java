package eapli.ecourse.exammanagement.application;

import eapli.ecourse.coursemanagement.application.ListCourseService;
import eapli.ecourse.coursemanagement.dto.CourseDTO;
import eapli.ecourse.coursemanagement.repositories.CourseRepository;
import eapli.ecourse.exammanagement.application.exceptions.ParseException;
import eapli.ecourse.exammanagement.domain.evaluation.ExamScore;
import eapli.ecourse.exammanagement.domain.formative.FormativeExam;
import eapli.ecourse.exammanagement.domain.parsers.ANTLR4TakeExamParser;
import eapli.ecourse.exammanagement.domain.parsers.GrammarParser;
import eapli.ecourse.exammanagement.dto.FormativeExamDTO;
import eapli.ecourse.exammanagement.repositories.FormativeExamRepository;
import eapli.ecourse.studentmanagement.domain.Student;
import eapli.ecourse.studentmanagement.repositories.StudentRepository;
import eapli.ecourse.usermanagement.domain.ClientRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

@UseCaseController
public class TakeFormativeExamController {
  private final ListCourseService listCourseService;
  private final AuthorizationService authz;
  private final StudentRepository studentRepository;
  private final CourseRepository courseRepository;
  private final FormativeExamRepository formativeExamRepository;
  private final GrammarParser<ExamScore> parser;
  private final FormativeExamListService service;

  private Student student;

  public TakeFormativeExamController(final AuthorizationService authz, final StudentRepository studentRepository,
      final CourseRepository courseRepository, final FormativeExamRepository formativeExamRepository) {
    this.authz = authz;
    this.studentRepository = studentRepository;
    this.courseRepository = courseRepository;
    this.listCourseService = new ListCourseService(courseRepository);
    this.formativeExamRepository = formativeExamRepository;
    this.service = new FormativeExamListService(formativeExamRepository);
    this.parser = new ANTLR4TakeExamParser();
  }

  public void setCurrentAuthenticatedStudent() {
    authz.ensureAuthenticatedUserHasAnyOf(ClientRoles.POWER_USER, ClientRoles.STUDENT);
    SystemUser authenticatedUser = authz.loggedinUserWithPermissions(ClientRoles.STUDENT).orElseThrow();

    student = studentRepository.findByUsername(authenticatedUser.username()).orElseThrow();
  }

  public Iterable<CourseDTO> listInProgressCoursesOfAuthenticatedStudent() {
    authz.ensureAuthenticatedUserHasAnyOf(ClientRoles.POWER_USER, ClientRoles.STUDENT);
    setCurrentAuthenticatedStudent();
    return listCourseService.listInProgressCoursesThatStudentIsEnrolled(student);
  }

  public Iterable<FormativeExamDTO> listFormativeExams(CourseDTO courseDTO) {

    return service.findAllCourseExams(courseRepository.ofIdentity(courseDTO.getCode()).orElseThrow());
  }

  public void parseExam(final String str, ExamPrinter printer) throws ParseException {
    authz.ensureAuthenticatedUserHasAnyOf(ClientRoles.POWER_USER, ClientRoles.STUDENT);
    setCurrentAuthenticatedStudent();
    parser.parseFromString(str, printer);
  }

  public FormativeExam getFormativeExamSelected(FormativeExamDTO dto) {
    return formativeExamRepository.findByIdentifier(dto.getIdentifier());
  }
}
