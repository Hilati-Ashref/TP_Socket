package ServerSide;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerSend {
    public ServerSend ( DatagramSocket serverSocket, InetAddress IP, String msgSnd, int port ) {
        try {
            while (true) {
                byte[] dataSnd = msgSnd.getBytes();
                DatagramPacket pkSend = new DatagramPacket(dataSnd, dataSnd.length, IP, port);
                serverSocket.send(pkSend);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}