package dao;

import Model.User;
import Model.Message;
import ServerSide.ServerSend;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class gestion implements Igestion {
    private static List<User> listUsers = new ArrayList();
    private static List<Message> listMessages = new ArrayList();

    public gestion() {
    }

    public void commandManager ( DatagramPacket pkRcv ) throws SocketException {
        String msgRcv = new String(pkRcv.getData());
        InetAddress IPClient = pkRcv.getAddress();
        int portClient = pkRcv.getPort();
        if (msgRcv.startsWith("##")) {
            if ((msgRcv.substring(2).startsWith("login")) && (msgRcv.length() > 8) ){
                //##login userName
                Login(new User(msgRcv.substring(8),IPClient, portClient));
            } else if ((msgRcv.substring(2).startsWith("signup")) && (msgRcv.length() > 9)){
                //##signup userName name
                addUser(new User(msgRcv.substring(9),IPClient, portClient));
            } else if ((msgRcv.substring(2).startsWith("logout")) && (msgRcv.length() == 9)){
                //##logout
                logout(IPClient, portClient);
            } else if ((msgRcv.substring(2).startsWith("listUsers")) && (msgRcv.length() == 11)) {
                //##listUsers
                listUsers(IPClient, portClient);
            } else if ((msgRcv.substring(2).startsWith("sendmsg")) && (msgRcv.length() > 10)) {
                //##sendmsg to@reciepientUserName messageBody
                sendMsg(msgRcv.substring(10),IPClient, portClient);
            } else {
                new ServerSend("Wrong command!", IPClient, portClient);
            }
        } else {
            new ServerSend( "Massage needs to start with `##`", IPClient, portClient);
        }
    }

    @Override
    public void addUser ( User u ) {
        String[] credentials = u.getUserName().split(" ");
        if (credentials.length != 2){
            new ServerSend("Wrong command!", u.getIP(), u.getPort());
            return;
        }
        for (User i : listUsers) {
            if (i.getUserName().equals(credentials[0])){
                new ServerSend( "Username `" + credentials[0] + "` already used !", u.getIP(), u.getPort());
                return;
            }
        }
        listUsers.add(new User(credentials[0], credentials[1], u.getIP(), u.getPort(), true));
        new ServerSend( "You are signed up, welcome " + credentials[1], u.getIP(), u.getPort());
    }

    @Override
    public void Login ( User u ) {
        for (User i : listUsers) {
            if (i.getUserName().equals(u.getUserName())){
                i.setIP(u.getIP());
                i.setPort(u.getPort());
                if (i.isOnlineState()){
                    new ServerSend( "You are already logged in, welcome " + i.getName(), u.getIP(), u.getPort());
                } else {
                    i.setOnlineState(true);
                    new ServerSend( "Welcome " + i.getName(), u.getIP(), u.getPort());
                }
                return;
            }
        }
        new ServerSend( "The userName `" + u.getUserName() + "` does not exist!", u.getIP(), u.getPort());
    }

    @Override
    public void listUsers (InetAddress IPClient, int portClient) {
        if (isLoggedin(IPClient, portClient)){
            new ServerSend( "List of users: " + listUsers.toString(), IPClient, portClient);
            return;
        }
        new ServerSend( "You need to login first.", IPClient, portClient);
    }

    @Override
    public boolean isLoggedin ( InetAddress IPClient, int portClient ) {
        for (User i : listUsers) {
            if (i.getIP().equals(IPClient) && i.getPort() == portClient){
                return i.isOnlineState();
            }
        }
        return false;
    }

    @Override
    public void logout ( InetAddress IPClient, int portClient ) {
        for (User i : listUsers) {
            if (i.getIP().equals(IPClient) && i.getPort() == portClient){
                if (i.isOnlineState()){
                    i.setOnlineState(false);
                    new ServerSend( "You are now logged out", IPClient, portClient);
                } else {
                    new ServerSend( "You are not logged in." , IPClient, portClient);
                }
                return;
            }
        }
        new ServerSend( "You are not logged in." , IPClient, portClient);
    }

    @Override
    public void sendMsg ( String msg, InetAddress IPClient, int portClient ) {
        if (!isLoggedin(IPClient, portClient)){
            new ServerSend( "You need to login first.", IPClient, portClient);
            return;
        }
        String[] options = msg.split(" ");
        if (options.length < 2){
            new ServerSend("Wrong message command!", IPClient, portClient);
            return;
        }
        for (User i : listUsers) {
            if (i.getUserName().equals(options[0].substring(3))){
                listMessages.add(new Message(msg.substring(options[0].length()+1),i, getUser(IPClient, portClient)));
                if (i.isOnlineState()){
                    new ServerSend( "You have a new message!\n", i.getIP(), i.getPort());
                }
                return;
            }
        }
        new ServerSend( "Receiver does not exist!" , IPClient, portClient);
    }


    private static User getUser(InetAddress IPClient, int portClient){
        for (User i : listUsers) {
            if (i.getIP().equals(IPClient) && i.getPort() == portClient){
                return i;
            }
        }
        return null;
    }
}
