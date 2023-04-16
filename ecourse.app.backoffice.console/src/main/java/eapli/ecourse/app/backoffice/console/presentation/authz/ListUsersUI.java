package eapli.ecourse.app.backoffice.console.presentation.authz;

import eapli.ecourse.usermanagement.application.ListUsersController;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

/**
 *
 * @author losa
 */
@SuppressWarnings({"squid:S106"})
public class ListUsersUI extends AbstractListUI<SystemUser> {
  private final ListUsersController theController = new ListUsersController();

  @Override
  public String headline() {
    return "List Users";
  }

  @Override
  protected String emptyMessage() {
    return "No data.";
  }

  @Override
  protected Iterable<SystemUser> elements() {
    return theController.allUsers();
  }

  @Override
  protected Visitor<SystemUser> elementPrinter() {
    return new SystemUserPrinter();
  }

  @Override
  protected String elementName() {
    return "User";
  }

  @Override
  protected String listHeader() {
    return String.format("#  %-10s%-30s%-30s", "USERNAME", "F. NAME", "L. NAME");
  }
}