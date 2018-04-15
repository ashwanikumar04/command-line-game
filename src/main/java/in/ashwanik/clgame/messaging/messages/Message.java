package in.ashwanik.clgame.messaging.messages;

/**
 * Created by Ashwani Kumar on 13/04/18.
 */
public class Message {
    private String topic;
    private String sender;
    private String receiver;
    private MessageType messageType;

    public Message(String topic, String sender, String receiver, MessageType messageType) {
        this.topic = topic;
        this.sender = sender;
        this.receiver = receiver;
        this.messageType = messageType;
    }

    public String getTopic() {
        return this.topic;
    }

    public String getSender() {
        return this.sender;
    }

    public String getReceiver() {
        return this.receiver;
    }

    public MessageType getMessageType() {
        return this.messageType;
    }
}
