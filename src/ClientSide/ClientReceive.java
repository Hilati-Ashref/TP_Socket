package ClientSide;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientReceive extends Thread {
    private DatagramSocket cltSock;
    private byte[] dataRcv = new byte[1024];

    public ClientReceive(DatagramSocket cltSock) {
        this.cltSock = cltSock;
    }

    public void run() {
        try {
            DatagramPacket pkRcv = new DatagramPacket(dataRcv, dataRcv.length);
            cltSock.receive(pkRcv);

            String msgRcv = new String(pkRcv.getData(), 0, pkRcv.getLength());
            System.out.println("message du serveur:" + msgRcv);
        } catch (IOException e) {
//          e.printStackTrace();
            System.out.println("error in Client Receive");
        }
    }

    public void closeSocket() {
        cltSock.close();
    }
}
