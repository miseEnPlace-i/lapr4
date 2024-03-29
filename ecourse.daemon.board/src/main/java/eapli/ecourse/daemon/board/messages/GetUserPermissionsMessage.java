package eapli.ecourse.daemon.board.messages;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Optional;

import javax.json.JsonStructure;
import javax.json.JsonValue.ValueType;
import eapli.ecourse.boardmanagement.application.ShareBoardController;
import eapli.ecourse.boardmanagement.domain.BoardID;
import eapli.ecourse.boardmanagement.dto.UserPermissionDTO;
import eapli.ecourse.boardmanagement.repositories.BoardRepository;
import eapli.ecourse.common.board.EventListener;
import eapli.ecourse.common.board.SafeBoardUpdatesCounter;
import eapli.ecourse.common.board.SafeOnlineCounter;
import eapli.ecourse.common.board.protocol.MessageCode;
import eapli.ecourse.common.board.protocol.ProtocolMessage;
import eapli.ecourse.daemon.board.clientstate.ClientState;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.strings.util.StringPredicates;

/**
 * Get the user permissions to a specific board.
 */
public class GetUserPermissionsMessage extends Message {
  private final BoardRepository boardRepository;
  private final UserManagementService userSvc;
  private final ShareBoardController ctrl;

  public GetUserPermissionsMessage(ProtocolMessage protocolMessage, DataOutputStream output,
      Socket socket, SafeOnlineCounter onlineCounter, SafeBoardUpdatesCounter boardUpdatesCounter,
      EventListener eventListener) {
    super(protocolMessage, output, socket, onlineCounter, boardUpdatesCounter, eventListener);

    this.boardRepository = PersistenceContext.repositories().boards();
    this.userSvc = AuthzRegistry.userService();
    this.ctrl = new ShareBoardController(boardRepository, userSvc);
  }

  @Override
  public void handle() throws IOException {
    ClientState clientState = ClientState.getInstance();

    // ignore requests from unauthenticated clients
    if (!clientState.getCredentialStore().isAuthenticated())
      return;

    JsonStructure json = request.getPayloadAsJson();

    // check if json is valid
    if (json == null || !json.getValueType().equals(ValueType.OBJECT)) {
      send(new ProtocolMessage(MessageCode.ERR, "Bad Request"));
      return;
    }

    String boardIdStr = json.asJsonObject().getString("boardId");
    String usernameStr = json.asJsonObject().getString("username");

    if (boardIdStr == null || usernameStr == null || usernameStr.length() == 0
        || !StringPredicates.isSingleWord(usernameStr)) {
      send(new ProtocolMessage(MessageCode.ERR, "Bad Request"));
      return;
    }

    BoardID boardId = BoardID.valueOf(boardIdStr);
    Username authUsername =
        Username.valueOf(clientState.getCredentialStore().getUser().getUsername());

    // verify if the board with the given id exists
    if (!ctrl.boardExists(boardId)) {
      send(new ProtocolMessage(MessageCode.ERR, "Board not found"));
      return;
    }

    // check if the authenticated user has read permission
    if (!ctrl.isBoardParticipant(boardId, authUsername)) {
      send(new ProtocolMessage(MessageCode.ERR, "Unauthorized"));
      return;
    }

    // verify if the user with the given username exists
    Optional<SystemUser> user = userSvc.userOfIdentity(Username.valueOf(usernameStr));

    if (!user.isPresent()) {
      send(new ProtocolMessage(MessageCode.ERR, "User not found"));
      return;
    }

    Username username = Username.valueOf(usernameStr);

    // check if the user is owner of the board
    if (ctrl.isBoardOwner(boardId, username)) {
      send(new ProtocolMessage(MessageCode.ERR, "User is the owner of the board"));
      return;
    }

    UserPermissionDTO userPermission = ctrl.getUserPermission(boardId, username);

    send(new ProtocolMessage(MessageCode.GET_USER_PERMISSIONS, userPermission));
  }
}
