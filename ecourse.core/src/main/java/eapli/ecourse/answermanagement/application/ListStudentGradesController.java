package eapli.ecourse.answermanagement.application;

import eapli.ecourse.answermanagement.dto.ExamAnswerDTO;
import eapli.ecourse.answermanagement.repositories.ExamAnswerRepository;
import eapli.ecourse.coursemanagement.dto.CourseDTO;
import eapli.ecourse.enrolmentmanagement.application.ListEnrolmentService;
import eapli.ecourse.enrolmentmanagement.repositories.EnrolmentRepository;
import eapli.ecourse.exammanagement.repositories.EvaluationExamRepository;
import eapli.ecourse.exammanagement.repositories.FormativeExamRepository;
import eapli.ecourse.studentmanagement.repositories.StudentRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;

public class ListStudentGradesController {
  private final StudentRepository studentRepository;
  private final AuthorizationService authenticationService;

  private final ListEnrolmentService listEnrolmentService;
  private final ListExamAnswerService listExamAnswerService;

  public ListStudentGradesController(EnrolmentRepository enrolmentRepository, ExamAnswerRepository examAnswerRepository,
      StudentRepository studentRepository, FormativeExamRepository formativeExamRepository,
      EvaluationExamRepository evaluationExamRepository, AuthorizationService authenticationService) {
    this.studentRepository = studentRepository;
    this.authenticationService = authenticationService;

    this.listEnrolmentService = new ListEnrolmentService(enrolmentRepository);
    this.listExamAnswerService = new ListExamAnswerService(examAnswerRepository, evaluationExamRepository,
        formativeExamRepository);
  }

  public Iterable<ExamAnswerDTO> listStudentGrades() {
    // TODO
    return null;
  }

  public Iterable<CourseDTO> listStudentCourses() {

  }
}
