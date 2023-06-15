package eapli.ecourse.daemon.board.messages;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import eapli.ecourse.common.board.SafeOnlineCounter;
import eapli.ecourse.common.board.protocol.MessageCode;
import eapli.ecourse.common.board.protocol.ProtocolMessage;

public class BadRequestMessage extends Message {
  public BadRequestMessage(DataOutputStream output, Socket socket) {
    super(null, output, socket, null);
  }

  public BadRequestMessage(ProtocolMessage protocolMessage, DataOutputStream output, Socket socket,
      SafeOnlineCounter onlineCounter) {
    super(protocolMessage, output, socket, onlineCounter);
  }

  @Override
  public void handle() throws IOException {
    super.send(new ProtocolMessage(MessageCode.ERR, "Bad Request"));
  }
}
