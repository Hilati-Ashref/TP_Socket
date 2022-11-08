package dao;

import Model.User;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.SocketException;

public interface Igestion {
    public void commandManager( DatagramPacket pkRcv ) throws SocketException;
    public void addUser( User u );

    public void Login ( User u);
    public void logout ( InetAddress IPClient, int portClient );
    public boolean isLoggedin ( InetAddress IPClient, int portClient );

    public void listUsers( InetAddress IPClient, int portClient );

    public void sendMsg( String msg, InetAddress IPClient, int portClient );
}
