package ClientSide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ClientSend extends Thread {
    private DatagramSocket cltSock;
    private InetAddress ipServer = InetAddress.getByName("127.0.0.1");
    private int portSrv = 9876;
    private  byte[] dataSnd ;

    public ClientSend(DatagramSocket cltSock) throws UnknownHostException {
        this.cltSock = cltSock;
    }

    public void run() {
        try {
            System.out.println("Donner votre pseudo: ");
            BufferedReader inClavier = new BufferedReader(new InputStreamReader(System.in));
            String msg = inClavier.readLine();

            dataSnd = msg.getBytes();
            DatagramPacket pkSend = new DatagramPacket(dataSnd, dataSnd.length, ipServer, portSrv);
            cltSock.send(pkSend);

        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("error in Client Send");
        }
    }

    public void closeSocket() {
        cltSock.close();
    }
}
