package dao;

import Model.User;

import java.net.DatagramPacket;
import java.net.SocketException;

public interface Igestion {
    public void commandManager( DatagramPacket pkRcv ) throws SocketException;
    public void addUser( User u );

    public void verifLogin(User u);

    public void listUsers();

    public void sendMsg(String recipientUserName, String msg);
}