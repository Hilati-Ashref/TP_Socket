package ClientSide;

import ServerSide.ServerReceive;
import ServerSide.ServerSend;
import org.junit.Before;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.UnknownHostException;

public class ClientUDP extends Thread {
    DatagramSocket cltSock;
    ClientSend client;

    @Before
    public void setup() throws UnknownHostException {
        client = new ClientSend(cltSock);
    }

    public ClientUDP() throws IOException {
        super();
        System.out.println("client");
        DatagramSocket cltSock = new DatagramSocket();
        ClientSend clSend = new ClientSend(cltSock);
        clSend.start();
//        ClientSend clRcv = new ClientSend(cltSock);
//        clRcv.start();
    }
}
