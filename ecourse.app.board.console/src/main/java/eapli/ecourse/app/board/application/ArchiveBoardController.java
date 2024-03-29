package eapli.ecourse.app.board.application;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import eapli.ecourse.app.board.lib.BoardBackend;
import eapli.ecourse.app.board.lib.MessageListener;
import eapli.ecourse.boardmanagement.dto.BoardDTO;
import eapli.ecourse.common.board.protocol.MessageCode;
import eapli.ecourse.common.board.protocol.ProtocolMessage;
import eapli.ecourse.common.board.protocol.UnsupportedVersionException;

public class ArchiveBoardController {
  private MessageListener listener;

  public ArchiveBoardController() {
    this.listener = BoardBackend.getInstance().getListener();
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

  public void archiveBoard(BoardDTO boardDto) throws IOException, UnsupportedVersionException,
      UnsuccessfulRequestException, ClassNotFoundException {
    ProtocolMessage response = listener
        .sendRecv(new ProtocolMessage(MessageCode.ARCHIVE_BOARD, boardDto.getId().toString()),
            MessageCode.ARCHIVE_BOARD);

    if (response.getCode().equals(MessageCode.ERR))
      throw new UnsuccessfulRequestException(response);
  }
}
