package Model;

import java.net.InetAddress;

public class User {
    private String nom, userName;
    private InetAddress IP;
    private int    port;
    private boolean onlineState;

    public User () {
    }

    public User ( String nom, String userName, InetAddress IP, int port, boolean onlineState ) {
        this.nom         = nom;
        this.userName    = userName;
        this.IP          = IP;
        this.port        = port;
        this.onlineState = onlineState;
    }

    public String getNom () {
        return nom;
    }

    public void setNom ( String nom ) {
        this.nom = nom;
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
        return "User{" +
                "nom='" + nom + '\'' +
                ", userName='" + userName + '\'' +
                ", IP=" + IP +
                ", port=" + port +
                ", onlineState=" + onlineState +
                '}';
    }

}