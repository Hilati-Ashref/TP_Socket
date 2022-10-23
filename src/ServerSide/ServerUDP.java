package ServerSide;

import dao.gestion;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServerUDP extends Thread{
    private int rcvPort = 9876 ;
    DatagramSocket serverSocketRcv;
    DatagramSocket serverSocketSnd;
    private boolean running;
    private byte[] dataRcv = new byte[1024];

    gestion g = new gestion();
    public ServerUDP (DatagramSocket sUp, DatagramSocket sDown) throws SocketException {
            this.serverSocketSnd = sDown;
            this.serverSocketRcv = sUp;
    }

    public void run(){
        System.out.println("Serveur");
        running = true;
        try {
            while (running) {
                DatagramPacket pkRcv = new DatagramPacket(dataRcv, dataRcv.length);
                serverSocketRcv.receive(pkRcv);
//                pkRcv = new DatagramPacket(pkRcv.getData(), pkRcv.getLength(), pkRcv.getAddress(), pkRcv.getPort());

                String received = new String(pkRcv.getData(), 0, pkRcv.getLength());
                if (received.equals("quit")) {
                    running = false;
                    continue;
                } else {
                    g.commandManager(pkRcv, serverSocketSnd);
                }
                serverSocketRcv.close();
            }
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("error in ServerUDP");
        }
    }
}
