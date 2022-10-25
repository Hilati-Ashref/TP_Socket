package ClientSide;

import java.net.*;

public class ClientUDP {
    static DatagramSocket cltSock;

    public static void main ( String[] args ) throws UnknownHostException, SocketException {
        cltSock = new DatagramSocket();
        new ClientSend(cltSock).start();
        new ClientReceive(cltSock).start();
    }
}
