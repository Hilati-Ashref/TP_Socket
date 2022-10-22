package Model;

public class User {
    private String IP, userName;
    private int    port;

    public User () {
    }

    public User ( String IP, String userName, int port ) {
        this.IP       = IP;
        this.userName = userName;
        this.port     = port;
    }

    public String getIP () {
        return IP;
    }

    public void setIP ( String IP ) {
        this.IP = IP;
    }

    public String getUserName () {
        return userName;
    }

    public void setUserName ( String userName ) {
        this.userName = userName;
    }

    public int getPort () {
        return port;
    }

    public void setPort ( int port ) {
        this.port = port;
    }

    @Override
    public String toString () {
        return "User{" +
                "IP='" + IP + '\'' +
                ", userName='" + userName + '\'' +
                ", port=" + port +
                '}';
    }
}
