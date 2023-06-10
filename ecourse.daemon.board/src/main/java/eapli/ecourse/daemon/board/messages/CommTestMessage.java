package eapli.ecourse.daemon.board.messages;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import eapli.ecourse.common.board.protocol.MessageCode;
import eapli.ecourse.common.board.protocol.ProtocolMessage;

public class CommTestMessage extends Message {
  public CommTestMessage(ProtocolMessage protocolMessage, DataOutputStream output, Socket socket) {
    super(protocolMessage, output, socket);
  }

  @Override
  public void handle() throws IOException {
    send(new ProtocolMessage(MessageCode.ACK));
  }
}
