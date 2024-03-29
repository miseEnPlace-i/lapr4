package eapli.ecourse.infrastructure.bootstrapers.demo;

import java.util.HashSet;
import java.util.Set;

import eapli.ecourse.infrastructure.bootstrapers.UsersBootstrapperBase;
import eapli.ecourse.usermanagement.application.AddUserController;
import eapli.ecourse.usermanagement.domain.ClientRoles;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.Role;

/**
 * @author Paulo Gandra Sousa
 */
public class BackofficeUsersBootstrapper extends UsersBootstrapperBase implements Action {
  private final AddUserController controller = new AddUserController();
  @SuppressWarnings("squid:S2068")
  private static final String PASSWORD1 = "Password1";

  @Override
  public boolean execute() {
    registerTeacher("teacher", PASSWORD1, "Johny", "Cash", "johny.doe@emai.l.com");
    registerManager("manager", PASSWORD1, "Master", "Chef", "master.chef@emai.l.com");
    return true;
  }

  private void registerTeacher(final String username, final String password, final String firstName,
      final String lastName, final String email) {
    final Set<Role> roles = new HashSet<>();
    roles.add(ClientRoles.TEACHER);

    controller.addTeacher(username, password, firstName, lastName, email, "987654321", "20/02/1990", "pdf");
  }

  private void registerManager(final String username, final String password, final String firstName,
      final String lastName, final String email) {
    final Set<Role> roles = new HashSet<>();
    roles.add(ClientRoles.MANAGER);

    controller.addUser(username, password, firstName, lastName, email, roles);
  }
}
