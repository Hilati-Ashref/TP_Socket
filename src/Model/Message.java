package Model;

public class Message {
    private String content;
    private User receiver, sender;
    private boolean readState;

    public Message () {
    }

    public Message ( String content, User receiver, User sender ) {
        this.content  = content;
        this.receiver = receiver;
        this.sender   = sender;
    }

    public Message ( String content, User receiver, User sender, boolean readState ) {
        this.content   = content;
        this.receiver  = receiver;
        this.sender    = sender;
        this.readState = readState;
    }

    @Override
    public String toString () {
        return "\nMessage from '"+ sender.getName() + "' : " + content;
    }

    public String getContent () {
        return content;
    }

    public void setContent ( String content ) {
        this.content = content;
    }

    public User getReceiver () {
        return receiver;
    }

    public void setReceiver ( User receiver ) {
        this.receiver = receiver;
    }

    public User getSender () {
        return sender;
    }

    public void setSender ( User sender ) {
        this.sender = sender;
    }

    public boolean isReadState () {
        return readState;
    }

    public void setReadState ( boolean readState ) {
        this.readState = readState;
    }
}
