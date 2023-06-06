package eapli.ecourse.daemon.board;

import eapli.ecourse.AppSettings;
import eapli.ecourse.common.board.TcpServer;
import eapli.ecourse.infrastructure.auth.PasswordEncoderContext;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.usermanagement.domain.ClientPasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

/**
 * Shared Board Server.
 *
 * This application holds a TCP server used to communicate with the Shared Board App by using the
 * defined protocol.
 */
public class App {
  // move to properties
  private static final int BOARD_SERVER_PORT = 9999;
  AppSettings appSettings = new AppSettings();

  public static void main(String[] args) {
    AuthzRegistry.configure(PersistenceContext.repositories().users(), new ClientPasswordPolicy(),
        PasswordEncoderContext.passwordHash());

    TcpServer server = new TcpServer(BOARD_SERVER_PORT, ClientHandler.class);
    server.run();
  }
}