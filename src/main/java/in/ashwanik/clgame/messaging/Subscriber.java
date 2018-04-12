package in.ashwanik.clgame.messaging;

@FunctionalInterface
public interface Subscriber {
    void receive(Message message);
}
