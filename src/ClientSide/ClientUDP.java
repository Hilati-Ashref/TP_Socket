package ClientSide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class ClientUDP extends Thread {
    DatagramSocket cltSockSnd;
    DatagramSocket cltSockRcv;
    private byte[]      dataSnd;
    private byte[]      dataRcv = new byte[1024];
    private InetAddress ipServer   = InetAddress.getByName("127.0.0.1");
    private int         portSrvSnd = 9876;
    private int         portSrvRcv = 9875;

    public ClientUDP(DatagramSocket sUp, DatagramSocket sDown) throws IOException {
        super();
        this.cltSockRcv = sDown;
        this.cltSockSnd = sUp;
        System.out.println("client");
    }

    public void run() {
        try {
            System.out.println("Client state is up!");
            String msgInit = "helloMessage";
            dataSnd = msgInit.getBytes();
            DatagramPacket pkSend = new DatagramPacket(dataSnd, dataSnd.length, ipServer, portSrvSnd);
            cltSockSnd.send(pkSend);
            ClientReceive clRcv = new ClientReceive(cltSockRcv);
            while (true) {
                clRcv.run();
                BufferedReader inClavier = new BufferedReader(new InputStreamReader(System.in));
                String msg = inClavier.readLine();
                dataSnd = msg.getBytes();
                pkSend = new DatagramPacket(dataSnd, dataSnd.length, ipServer, portSrvSnd);
                cltSockRcv.send(pkSend);
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
