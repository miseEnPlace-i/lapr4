package eapli.ecourse.app.board.application;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.json.Json;
import javax.json.JsonObject;
import eapli.ecourse.app.board.lib.BoardBackend;
import eapli.ecourse.app.board.lib.MessageListener;
import eapli.ecourse.boardmanagement.dto.BoardDTO;
import eapli.ecourse.boardmanagement.dto.UserPermissionDTO;
import eapli.ecourse.common.board.protocol.MessageCode;
import eapli.ecourse.common.board.protocol.ProtocolMessage;
import eapli.ecourse.common.board.protocol.UnsupportedVersionException;

public class ShareBoardController {
  private MessageListener listener;

  public ShareBoardController() {
    listener = BoardBackend.getInstance().getListener();
  }

  public Iterable<BoardDTO> listUserBoards() throws IOException, UnsupportedVersionException,
      ClassNotFoundException, UnsuccessfulRequestException {
    ProtocolMessage response = listener.sendRecv(new ProtocolMessage(MessageCode.GET_OWN_BOARDS),
        MessageCode.GET_OWN_BOARDS);

    if (response.getCode().equals(MessageCode.ERR))
      throw new UnsuccessfulRequestException(response);
    Iterable<?> obj = (Iterable<?>) response.getPayloadAsObject();

    List<BoardDTO> result = StreamSupport.stream(obj.spliterator(), true).map(BoardDTO.class::cast)
        .collect(Collectors.toUnmodifiableList());

    return result;
  }

  public UserPermissionDTO userPermissions(BoardDTO board, String username) throws IOException,
      UnsupportedVersionException, UnsuccessfulRequestException, ClassNotFoundException {
    JsonObject payload = Json.createObjectBuilder().add("boardId", board.getId().toString())
        .add("username", username).build();

    ProtocolMessage response =
        listener.sendRecv(new ProtocolMessage(MessageCode.GET_USER_PERMISSIONS, payload),
            MessageCode.GET_USER_PERMISSIONS);

    if (response.getCode().equals(MessageCode.ERR))
      throw new UnsuccessfulRequestException(response);

    if (response.getPayloadLength() == 0)
      return null;

    return (UserPermissionDTO) response.getPayloadAsObject();
  }

  public UserPermissionDTO updateUserPermissions(BoardDTO board, String username,
      String newPermission) throws IOException, UnsupportedVersionException,
      UnsuccessfulRequestException, ClassNotFoundException {

    JsonObject payload = Json.createObjectBuilder().add("boardId", board.getId().toString())
        .add("username", username).add("permission", newPermission).build();

    ProtocolMessage response = listener
        .sendRecv(new ProtocolMessage(MessageCode.SHARE_BOARD, payload), MessageCode.SHARE_BOARD);

    if (response.getCode().equals(MessageCode.ERR))
      throw new UnsuccessfulRequestException(response);

    return (UserPermissionDTO) response.getPayloadAsObject();
  }
}
