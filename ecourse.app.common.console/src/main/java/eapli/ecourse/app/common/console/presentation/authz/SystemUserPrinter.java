package eapli.ecourse.app.common.console.presentation.authz;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.visitor.Visitor;

/**
 *
 * @author Paulo Gandra de Sousa
 *
 */
@SuppressWarnings({ "squid:S106" })
public class SystemUserPrinter implements Visitor<SystemUser> {

  @Override
  public void visit(final SystemUser visitee) {
    System.out.printf("%-20s%-30s%-30s%-10s", visitee.username(), visitee.name().firstName(),
        visitee.name().lastName(), visitee.isActive() ? "X" : "");
  }
}
