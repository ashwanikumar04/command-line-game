package in.ashwanik.clgame.messaging.messages;

import in.ashwanik.clgame.commands.IssuedCommand;

/**
 * Created by Ashwani Kumar on 13/04/18.
 */
public class CommandMessage extends Message {
    private IssuedCommand payload;

    private CommandMessage(String topic, String sender, String receiver, MessageType messageType, IssuedCommand payload) {
        super(topic, sender, receiver, messageType);
        this.payload = payload;
    }

    public static CommandMessageBuilder builder() {
        return new CommandMessageBuilder();
    }

    public IssuedCommand getPayload() {
        return this.payload;
    }

    public static class CommandMessageBuilder {
        private String topic;
        private String sender;
        private String receiver;
        private MessageType messageType;
        private IssuedCommand payload;

        CommandMessageBuilder() {
        }

        public CommandMessage.CommandMessageBuilder topic(String topic) {
            this.topic = topic;
            return this;
        }

        public CommandMessage.CommandMessageBuilder sender(String sender) {
            this.sender = sender;
            return this;
        }

        public CommandMessage.CommandMessageBuilder receiver(String receiver) {
            this.receiver = receiver;
            return this;
        }

        public CommandMessage.CommandMessageBuilder messageType(MessageType messageType) {
            this.messageType = messageType;
            return this;
        }

        public CommandMessage.CommandMessageBuilder payload(IssuedCommand payload) {
            this.payload = payload;
            return this;
        }

        public CommandMessage build() {
            return new CommandMessage(topic, sender, receiver, messageType, payload);
        }

    }
}
