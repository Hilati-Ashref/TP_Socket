import ClientSide.ClientUDP;
import ServerSide.ServerUDP;

import java.io.IOException;
import java.net.DatagramSocket;

public class main {
    public static void main(String[] args) throws IOException {
        DatagramSocket sUp = new DatagramSocket(9876);
        DatagramSocket sDown = new DatagramSocket(9875);
        new ServerUDP(sUp, sDown).start();
        System.out.println("test1");
        new ClientUDP(sUp, sDown).start();
        System.out.println("test3");
    }
}
