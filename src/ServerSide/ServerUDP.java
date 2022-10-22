package ServerSide;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerUDP {
    public ServerUDP () throws IOException {
        System.out.println("Serveur");
        int port = 9876 ;
        DatagramSocket serverSocket = new DatagramSocket(port);
        while (true) {
            ServerReceive sRcv = new ServerReceive(serverSocket);
            sRcv.start();
        }
    }
}
