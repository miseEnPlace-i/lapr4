package eapli.ecourse.app.backoffice.console.presentation.courses;

import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.presentation.console.ShowMessageAction;

public class CoursesMenu {
  private static final int LIST_COURSES_OPTION = 1;
  private static final int TOGGLE_COURSE_STATE_OPTION = 2;
  private static final int TOGGLE_COURSE_ENROLMENT_STATE_OPTION = 3;
  private static final int EXIT_OPTION = 0;

  private static final String RETURN_LABEL = "Return ";

  public Menu buildCoursesMenu() {
    final Menu menu = new Menu("Courses >");

    menu.addItem(LIST_COURSES_OPTION, "List All Courses", new ShowMessageAction("Not implemented yet"));
    menu.addItem(TOGGLE_COURSE_STATE_OPTION, "Toggle Course State", new ShowMessageAction("Not implemented yet"));
    menu.addItem(TOGGLE_COURSE_ENROLMENT_STATE_OPTION, "Toggle Course Enrolment State",
        new ToggleCourseEnrolmentStateUI()::show);

    menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

    return menu;
  }
}
