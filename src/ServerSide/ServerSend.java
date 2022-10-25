package ServerSide;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerSend {
    public ServerSend ( String msgSnd, InetAddress IPClient, int portClient ) {
        try {
            DatagramSocket serverSocket = ServerUDP.serverSocket;
            byte[] dataSnd = msgSnd.getBytes();
            DatagramPacket pkSend = new DatagramPacket(dataSnd, dataSnd.length, IPClient, portClient);
            serverSocket.send(pkSend);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}