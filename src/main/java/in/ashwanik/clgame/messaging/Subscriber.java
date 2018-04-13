package in.ashwanik.clgame.messaging;

import in.ashwanik.clgame.messaging.messages.Message;

@FunctionalInterface
public interface Subscriber {
    void receive(Message message);
}
