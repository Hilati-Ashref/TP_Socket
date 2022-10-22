package ServerSide;

import dao.gestion;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerReceive extends Thread {
    private DatagramSocket serverSocket;
    private boolean running;
    private byte[] dataRcv = new byte[1024];

    gestion g;

    public ServerReceive ( DatagramSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void run() {
        running = true;
        try {
            System.out.println("Enter something :");
            while (running) {
                DatagramPacket pkRcv = new DatagramPacket(dataRcv, dataRcv.length);
                serverSocket.receive(pkRcv);
                pkRcv = new DatagramPacket(dataRcv, dataRcv.length, pkRcv.getAddress(), pkRcv.getPort());

                String received = new String(pkRcv.getData(), 0, pkRcv.getLength());
                if (received.equals("quit")) {
                    running = false;
                    continue;
                } else {
                    g.commandManager(pkRcv);
                }
                serverSocket.close();
            }
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("error in Server Receive");
        }
    }
}