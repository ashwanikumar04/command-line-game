package in.ashwanik.clgame.messaging.messages;

/**
 * Created by Ashwani Kumar on 13/04/18.
 */
public class GameStateMessage extends Message {
    private Object payload;

    private GameStateMessage(String topic, String sender, String receiver, MessageType messageType, Object payload) {
        super(topic, sender, receiver, messageType);
        this.payload = payload;
    }

    public static GameStateMessageBuilder builder() {
        return new GameStateMessageBuilder();
    }

    public Object getPayload() {
        return this.payload;
    }

    public static class GameStateMessageBuilder {
        private String topic;
        private String sender;
        private String receiver;
        private MessageType messageType;
        private Object payload;

        GameStateMessageBuilder() {
        }

        public GameStateMessage.GameStateMessageBuilder topic(String topic) {
            this.topic = topic;
            return this;
        }

        public GameStateMessage.GameStateMessageBuilder sender(String sender) {
            this.sender = sender;
            return this;
        }

        public GameStateMessage.GameStateMessageBuilder receiver(String receiver) {
            this.receiver = receiver;
            return this;
        }

        public GameStateMessage.GameStateMessageBuilder messageType(MessageType messageType) {
            this.messageType = messageType;
            return this;
        }

        public GameStateMessage.GameStateMessageBuilder payload(Object payload) {
            this.payload = payload;
            return this;
        }

        public GameStateMessage build() {
            return new GameStateMessage(topic, sender, receiver, messageType, payload);
        }

    }
}
