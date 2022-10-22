import ClientSide.ClientUDP;
import ServerSide.ServerUDP;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        System.out.println("test1");
        ServerUDP s = new ServerUDP();
        new ClientUDP().start();
        System.out.println("test3");
    }
}
