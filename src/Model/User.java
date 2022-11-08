package Model;

import java.net.InetAddress;

public class User {
    private String name, userName;
    private InetAddress IP;
    private int    port;
    private boolean onlineState;

    public User () {
    }

    public User ( String userName, InetAddress IP, int port ) {
        this.userName    = userName;
        this.IP          = IP;
        this.port        = port;
    }

    public User ( String userName, String name, InetAddress IP, int port, boolean onlineState ) {
        this.name        = name;
        this.userName    = userName;
        this.IP          = IP;
        this.port        = port;
        this.onlineState = onlineState;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getUserName () {
        return userName;
    }

    public void setUserName ( String userName ) {
        this.userName = userName;
    }

    public InetAddress getIP () {
        return IP;
    }

    public void setIP ( InetAddress IP ) {
        this.IP = IP;
    }

    public int getPort () {
        return port;
    }

    public void setPort ( int port ) {
        this.port = port;
    }

    public boolean isOnlineState () {
        return onlineState;
    }

    public void setOnlineState ( boolean onlineState ) {
        this.onlineState = onlineState;
    }

    @Override
    public String toString () {
        return "\nname='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", onlineState=" + onlineState;
    }

}