package eapli.ecourse.infrastructure.bootstrapers.demo;

import java.io.IOException;
import java.util.Calendar;
import java.util.Collection;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.coursemanagement.domain.CourseCode;
import eapli.ecourse.eventsmanagement.domain.Time;
import eapli.ecourse.exammanagement.application.FormativeExamService;
import eapli.ecourse.exammanagement.domain.evaluation.EvaluationExam;
import eapli.ecourse.exammanagement.domain.evaluation.EvaluationExamBuilder;
import eapli.ecourse.exammanagement.domain.formative.FormativeExam;
import eapli.ecourse.exammanagement.domain.formative.FormativeExamRequest;
import eapli.ecourse.exammanagement.domain.formative.FormativeExamRequestBuilder;
import eapli.ecourse.exammanagement.domain.formative.FormativeExamSection;
import eapli.ecourse.exammanagement.domain.parsers.ExamsParser;
import eapli.ecourse.exammanagement.domain.parsers.FormativeExamsParser;
import eapli.ecourse.exammanagement.repositories.EvaluationExamRepository;
import eapli.ecourse.exammanagement.repositories.FormativeExamRepository;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.teachermanagement.domain.TaxPayerNumber;
import eapli.ecourse.teachermanagement.repositories.TeacherRepository;
import eapli.framework.actions.Action;

public class ExamBootstrapper implements Action {
  private Course course;

  private EvaluationExamBuilder evaluationBuilder;

  private FormativeExamRequestBuilder formativeBuilder;

  private TeacherRepository teacherRepository = PersistenceContext.repositories().teachers();

  private EvaluationExamRepository evaluationRepository = PersistenceContext.repositories().evaluationExams();

  private FormativeExamRepository formativeRepository = PersistenceContext.repositories().formativeExams();

  private FormativeExamService formativeExamService = new FormativeExamService(
      PersistenceContext.repositories().questions());

  @Override
  public boolean execute() {

    course = PersistenceContext.repositories().courses().ofIdentity(CourseCode.valueOf("2222")).get();
    try {
      evaluationBuilder = ExamsParser.parseWithVisitor("exam.txt");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    try {
      formativeBuilder = FormativeExamsParser.parseWithVisitor("formative.txt");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    addEvaluationExam();
    addFormativeExam();
    return false;
  }

  private void addEvaluationExam() {
    Calendar startTime = Calendar.getInstance();
    startTime.set(2023, Calendar.JULY, 23, 14, 30);

    Calendar endTime = Calendar.getInstance();
    endTime.set(2023, Calendar.JULY, 23, 15, 30);

    evaluationBuilder.withCourse(course).withTeacher(teacherRepository.ofIdentity(TaxPayerNumber.valueOf("212345678"))
        .orElseThrow()).withStartTime(Time.valueOf(startTime)).withEndTime(Time.valueOf(endTime));

    EvaluationExam exam = evaluationBuilder.build();

    evaluationRepository.save(exam);
  }

  private void addFormativeExam() {
    FormativeExamRequest request = formativeBuilder.build();

    try {
      Collection<FormativeExamSection> sections = formativeExamService.buildSections(request, course.toDto());

      FormativeExam exam = new FormativeExam(course,
          teacherRepository.ofIdentity(TaxPayerNumber.valueOf("212345678")).get(),
          request.identifier(), request.title(), request.description(), sections);

      formativeRepository.save(exam);
    } catch (Exception e) {
      throw new IllegalArgumentException("Invalid exam request");
    }
  }
}
