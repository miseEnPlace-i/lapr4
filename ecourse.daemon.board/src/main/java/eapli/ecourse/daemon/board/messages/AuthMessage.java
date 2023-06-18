package eapli.ecourse.daemon.board.messages;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Optional;
import eapli.ecourse.common.board.EventListener;
import eapli.ecourse.common.board.SafeBoardUpdatesCounter;
import eapli.ecourse.common.board.SafeOnlineCounter;
import eapli.ecourse.common.board.protocol.MessageCode;
import eapli.ecourse.common.board.protocol.ProtocolMessage;
import eapli.ecourse.daemon.board.clientstate.ClientState;
import eapli.ecourse.infrastructure.authz.AuthenticationCredentialHandler;
import eapli.ecourse.infrastructure.authz.CredentialHandler;
import eapli.ecourse.usermanagement.dto.UserDTO;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;

public class AuthMessage extends Message {
  public AuthMessage(ProtocolMessage protocolMessage, DataOutputStream output, Socket socket,
      SafeOnlineCounter onlineCounter, SafeBoardUpdatesCounter boardUpdatesCounter,
      EventListener eventListener) {
    super(protocolMessage, output, socket, onlineCounter, boardUpdatesCounter, eventListener);
  }

  @Override
  public void handle() throws IOException {
    CredentialHandler credentialHandler = new AuthenticationCredentialHandler();
    ClientState clientState = ClientState.getInstance();
    UserManagementService userSvc = AuthzRegistry.userService();

    if (clientState.getCredentialStore().isAuthenticated()) {
      // ignore
      return;
    }

    String payload = new String(request.getPayload());

    String fields[] = payload.split("\0");

    if (fields.length < 2) {
      send(new ProtocolMessage(MessageCode.ERR, "Bad Request"));
      return;
    }

    String username = fields[0], password = fields[1];

    // not logged in
    if (!credentialHandler.authenticated(username, password, null)) {
      send(new ProtocolMessage(MessageCode.ERR, "Wrong credentials!"));
      return;
    }

    // get the system user
    Optional<SystemUser> optional = userSvc.userOfIdentity(Username.valueOf(username));

    if (!optional.isPresent()) {
      send(new ProtocolMessage(MessageCode.ERR, "Wrong credentials!"));
      return;
    }

    // user.toDTO() is not very good
    UserDTO user = UserDTO.from(optional.get());

    clientState.getCredentialStore().store(user);

    send(new ProtocolMessage(MessageCode.ACK, user));

    // subscribe to all
    eventListener.subscribe("all", socket);
  }
}
