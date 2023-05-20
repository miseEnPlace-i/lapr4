package eapli.ecourse.app.teacher.console.presentation;

import eapli.ecourse.app.teacher.console.presentation.exams.CreateExamUI;
import eapli.ecourse.app.teacher.console.presentation.exams.ListCourseExamsUI;
import eapli.ecourse.app.teacher.console.presentation.questions.AddQuestionsUI;
import eapli.framework.actions.menu.Menu;

public class ExamMenu {
  private static final int ADD_QUESTIONS_OPTION = 1;
  private static final int CREATE_EXAM_OPTION = 2;
  private static final int LIST_COURSE_EXAMS = 3;

  public Menu buildMenu() {
    final Menu menu = new Menu("Exams");

    menu.addItem(ADD_QUESTIONS_OPTION, "Add Questions", new AddQuestionsUI()::show);
    menu.addItem(CREATE_EXAM_OPTION, "Create Exam", new CreateExamUI()::show);
    menu.addItem(LIST_COURSE_EXAMS, "List Course Exams", new ListCourseExamsUI()::show);

    return menu;
  }
}