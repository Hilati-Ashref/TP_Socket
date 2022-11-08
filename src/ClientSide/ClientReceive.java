package ClientSide;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ClientReceive extends Thread {
    private DatagramSocket cltSock;
    private byte[] dataRcv = new byte[1024];

    public ClientReceive(DatagramSocket cltSock) {
        this.cltSock = cltSock;
    }
    public void run() {
        try {
            while (true){
                DatagramPacket pkRcv = new DatagramPacket(dataRcv, dataRcv.length);
                cltSock.receive(pkRcv);
                String msgRcv = new String(pkRcv.getData(), 0, pkRcv.getLength());
                System.out.println("Server message: " + msgRcv);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
