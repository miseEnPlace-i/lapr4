package eapli.ecourse.app.teacher.console.presentation;

import eapli.ecourse.Application;
import eapli.ecourse.app.teacher.console.presentation.courseclass.ScheduleClassUI;
import eapli.ecourse.app.teacher.console.presentation.courseclass.ScheduleExtraClassUI;
import eapli.ecourse.app.teacher.console.presentation.courseclass.UpdateClassScheduleUI;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;

public class ClassesMenu {
  private static final int CHANGE_CLASS_SCHEDULE_OPTION = 1;
  private static final int SCHEDULE_CLASS_OPTION = 2;
  private static final int SCHEDULE_EXTRA_CLASS_OPTION = 3;
  private static final int EXIT_OPTION = 0;

  private static final String RETURN = "Return ";

  private static final String SEPARATOR_LABEL = "--------------";

  public Menu buildMenu() {
    final Menu menu = new Menu("Classes >");

    menu.addItem(CHANGE_CLASS_SCHEDULE_OPTION, "Change class schedule",
        new UpdateClassScheduleUI()::show);
    menu.addItem(SCHEDULE_CLASS_OPTION, "Schedule class", new ScheduleClassUI()::show);
    menu.addItem(SCHEDULE_EXTRA_CLASS_OPTION, "Schedule extra class",
        new ScheduleExtraClassUI()::show);

    if (!Application.settings().isMenuLayoutHorizontal())
      menu.addItem(MenuItem.separator(SEPARATOR_LABEL));

    menu.addItem(EXIT_OPTION, RETURN, Actions.SUCCESS);

    return menu;
  }
}
