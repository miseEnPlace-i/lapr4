package eapli.ecourse.app.student.console.presentation.exams;

import java.io.IOException;

import eapli.ecourse.app.common.console.presentation.course.CourseHeader;
import eapli.ecourse.app.common.console.presentation.course.CoursePrinter;
import eapli.ecourse.app.common.console.presentation.exam.EvaluationExamHeader;
import eapli.ecourse.app.common.console.presentation.exam.EvaluationExamPrinter;
import eapli.ecourse.coursemanagement.dto.CourseDTO;
import eapli.ecourse.exammanagement.application.TakeEvaluationExamController;
import eapli.ecourse.exammanagement.application.exceptions.ParseException;
import eapli.ecourse.exammanagement.dto.EvaluationExamDTO;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

public class TakeEvaluationExamUI extends AbstractUI {
  private TakeEvaluationExamController ctrl = new TakeEvaluationExamController(AuthzRegistry.authorizationService(),
      PersistenceContext.repositories().students(), PersistenceContext.repositories().evaluationExams(),
      PersistenceContext.repositories().courses());

  @Override
  protected boolean doShow() {
    CourseDTO course;
    if ((course = selectCourse()) == null)
      return false;

    EvaluationExamDTO exam;
    if ((exam = selectExam(course)) == null)
      return false;

    try {
      this.ctrl.parseExam(exam.getFileContent(), new ConsoleExamPrinter());
    } catch (ParseException ex) {
      System.out.println(ex.getMessage());
      return false;
    }

    System.out.println("\n\nExam taken successfully.");

    return false;
  }

  @Override
  public String headline() {
    return "Create Exam";
  }

  private CourseDTO selectCourse() {
    final Iterable<CourseDTO> courses = this.ctrl.listInProgressCoursesOfAuthenticatedStudent();

    if (!courses.iterator().hasNext()) {
      System.out.println("There are no courses in progress available to you. Please contact the administrator");
      return null;
    }

    System.out.println("Select the course of the exam you want to take:");
    final SelectWidget<CourseDTO> selector = new SelectWidget<>(new CourseHeader().header(), courses,
        new CoursePrinter());
    selector.show();
    final CourseDTO selectedCourse = selector.selectedElement();

    if (selectedCourse == null)
      return null;

    return selectedCourse;
  }

  private EvaluationExamDTO selectExam(CourseDTO course) {
    final Iterable<EvaluationExamDTO> exams = this.ctrl.listOpenExamsForCourse(course);

    if (!exams.iterator().hasNext()) {
      System.out.println("There are no currently open exams for the selected course.");
      return null;
    }

    System.out.println("Select the exam you want to take:");
    final SelectWidget<EvaluationExamDTO> selector = new SelectWidget<>(new EvaluationExamHeader().header(), exams,
        new EvaluationExamPrinter());
    selector.show();
    final EvaluationExamDTO selectedExam = selector.selectedElement();

    if (selectedExam == null)
      return null;

    return selectedExam;
  }
}
