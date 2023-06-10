package eapli.ecourse.daemon.board.messages;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import eapli.ecourse.boardmanagement.application.ListBoardsService;
import eapli.ecourse.boardmanagement.dto.BoardDTO;
import eapli.ecourse.common.board.dto.UserDTO;
import eapli.ecourse.common.board.protocol.MessageCode;
import eapli.ecourse.common.board.protocol.ProtocolMessage;
import eapli.ecourse.daemon.board.clientstate.ClientState;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.domain.model.Username;

/**
 * Get boards which the user owns.
 */
public class GetOwnBoardsMessage extends Message {
  private ListBoardsService listBoardsService;

  public GetOwnBoardsMessage(ProtocolMessage protocolMessage, DataOutputStream output,
      Socket socket) {
    super(protocolMessage, output, socket);
    this.listBoardsService = new ListBoardsService(PersistenceContext.repositories().boards());
  }

  @Override
  public void handle() throws IOException {
    ClientState clientState = ClientState.getInstance();

    // ignore requests from unauthenticated clients
    if (!clientState.getCredentialStore().isAuthenticated())
      return;

    UserDTO user = clientState.getCredentialStore().getUser();
    Username username = Username.valueOf(user.getUsername());

    Iterable<BoardDTO> boards = listBoardsService.userBoards(username);

    send(new ProtocolMessage(MessageCode.GET_OWN_BOARDS, boards));
  }
}
