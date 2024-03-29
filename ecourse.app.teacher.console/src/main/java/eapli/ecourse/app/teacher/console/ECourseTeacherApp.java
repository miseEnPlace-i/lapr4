package eapli.ecourse.app.teacher.console;

import eapli.ecourse.app.common.console.ECourseBaseApplication;
import eapli.ecourse.app.common.console.presentation.authz.LoginAction;
import eapli.ecourse.app.teacher.console.presentation.MainMenu;
import eapli.ecourse.infrastructure.auth.PasswordEncoderContext;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.usermanagement.domain.ClientPasswordPolicy;
import eapli.ecourse.usermanagement.domain.ClientRoles;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.pubsub.EventDispatcher;

@SuppressWarnings("squid:S106")
public final class ECourseTeacherApp extends ECourseBaseApplication {

  /**
   * Empty constructor is private to avoid instantiation of this class.
   */
  private ECourseTeacherApp() {}

  public static void main(final String[] args) {
    System.out.println();

    AuthzRegistry.configure(PersistenceContext.repositories().users(), new ClientPasswordPolicy(),
        PasswordEncoderContext.passwordHash());

    new ECourseTeacherApp().run(args);
  }

  @Override
  protected void doMain(String[] args) {
    if (new LoginAction(ClientRoles.TEACHER).execute()) {
      final MainMenu menu = new MainMenu();
      menu.mainLoop();
    }
  }

  @Override
  protected String appTitle() {
    return "Teacher App";
  }

  @Override
  protected String appGoodbye() {
    return "Signing out";
  }

  @Override
  protected void doSetupEventHandlers(EventDispatcher dispatcher) {
    // setup here event handlers for your app
  }

  @Override
  protected void configureAuthz() {
    AuthzRegistry.configure(PersistenceContext.repositories().users(), new ClientPasswordPolicy(),
        PasswordEncoderContext.passwordHash());
  }
}
