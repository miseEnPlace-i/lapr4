package eapli.ecourse.exammanagement.application;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.exammanagement.domain.Exam;
import eapli.ecourse.exammanagement.domain.ExamCode;
import eapli.ecourse.exammanagement.domain.evaluation.EvaluationExam;
import eapli.ecourse.exammanagement.dto.ExamDTO;
import eapli.ecourse.exammanagement.repositories.EvaluationExamRepository;

public class ExamListService {

  private EvaluationExamRepository examRepository;

  public ExamListService(EvaluationExamRepository examRepository) {
    this.examRepository = examRepository;
  }

  public Optional<ExamDTO> findByCode(ExamCode examCode) {
    final Optional<EvaluationExam> evaluationExam = examRepository.ofIdentity(examCode);
    return convertToDTO(evaluationExam);
  }

  public Iterable<ExamDTO> listAllCourseExams(Course course) {
    final Iterable<EvaluationExam> types = examRepository.findAllCourseExams(course);
    return convertToDto(types);
  }

  public Iterable<ExamDTO> listAllFutureCourseExams(Course course) {
    final Iterable<EvaluationExam> types = examRepository.findAllFutureCourseExams(course);
    return convertToDto(types);
  }

  private Iterable<ExamDTO> convertToDto(Iterable<EvaluationExam> exams) {
    return StreamSupport.stream(exams.spliterator(), true)
        .map(Exam::toDto)
        .collect(Collectors.toUnmodifiableList());
  }

  private Optional<ExamDTO> convertToDTO(Optional<EvaluationExam> courseOptional) {
    return courseOptional.map(Exam::toDto);
  }
}
