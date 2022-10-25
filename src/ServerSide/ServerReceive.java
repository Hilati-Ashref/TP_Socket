package ServerSide;

import dao.gestion;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServerReceive {
    private DatagramSocket serverSocket;
    private boolean running;
    private byte[] dataRcv = new byte[1024];
    gestion g = new gestion();

    public ServerReceive( DatagramSocket serverSocket ) throws SocketException {
        this.serverSocket = serverSocket;
        running = true;
        try {
            while (running) {
                DatagramPacket pkRcv = new DatagramPacket(dataRcv, dataRcv.length);
                serverSocket.receive(pkRcv);
                pkRcv = new DatagramPacket(dataRcv, dataRcv.length, pkRcv.getAddress(), pkRcv.getPort());

                String received = new String(pkRcv.getData(), 0, pkRcv.getLength());
                if (received.equals("quit")) {
                    running = false;
                } else {
                    g.commandManager(pkRcv);
                }
            }
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}