package dao;

import Model.User;
import ServerSide.ServerSend;
import ServerSide.ServerUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class gestion implements Igestion {

    public gestion() {
    }

    public void commandManager ( DatagramPacket pkRcv ) throws SocketException {
        String msgRcv = new String(pkRcv.getData());
        InetAddress IPClient = pkRcv.getAddress();
        int portClient = pkRcv.getPort();
        System.out.println(msgRcv);
        if (msgRcv.startsWith("##")) {
            new ServerSend( "testify112", IPClient, portClient);
        } else {
            new ServerSend( "testify000" + msgRcv, IPClient, portClient);
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
