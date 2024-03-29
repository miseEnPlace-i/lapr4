package eapli.ecourse.app.backoffice.console.presentation.enrolment;

import eapli.ecourse.Application;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;

public class EnrollmentsMenu {

  private static final int RESPOND_COURSE_APPLICATIONS_OPTION = 1;
  private static final int STUDENTS_BULK_ENROLMENT_OPTION = 2;
  private static final int EXIT_OPTION = 0;

  private static final String RETURN_LABEL = "Return ";

  private static final String SEPARATOR_LABEL = "--------------";

  public Menu buildEnrolmentsMenu() {
    final Menu menu = new Menu("Enrolments >");

    menu.addItem(RESPOND_COURSE_APPLICATIONS_OPTION, "Respond Course Applications",
        new RespondCourseApplicationsUI()::show);
    menu.addItem(STUDENTS_BULK_ENROLMENT_OPTION, "Enrol Students in Bulk",
        new EnrolStudentsInBulkUI()::show);

    if (!Application.settings().isMenuLayoutHorizontal())
      menu.addItem(MenuItem.separator(SEPARATOR_LABEL));

    menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

    return menu;
  }
}
