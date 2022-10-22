package dao;

import Model.User;
import ServerSide.ServerSend;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class gestion implements Igestion {

    public gestion() {
    }

    @Override
    public void commandManager ( DatagramPacket pkRcv ) throws SocketException {
        String msgRcv = new String(pkRcv.getData());
        InetAddress IPClient = pkRcv.getAddress();
        int portClient = pkRcv.getPort();
        DatagramSocket serverSocket = new DatagramSocket(portClient);

        if (msgRcv.startsWith("##")) {
            new ServerSend( serverSocket, IPClient, "testify112", portClient);
        } else {
            new ServerSend( serverSocket, IPClient, "testify000", portClient);
        }
    }

    @Override
    public void addUser ( User u ) {

    }

    @Override
    public void verifLogin ( User u ) {

    }

    @Override
    public void listUsers () {

    }

    @Override
    public void sendMsg ( String recipientUserName, String msg ) {

    }
}
