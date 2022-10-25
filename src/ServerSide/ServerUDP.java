package ServerSide;

import java.net.DatagramSocket;
import java.net.SocketException;

public class ServerUDP {
    static DatagramSocket serverSocket;
    public static void main ( String[] args ) throws SocketException {
        serverSocket = new DatagramSocket(9876);
        new ServerReceive(serverSocket);
    }
}
