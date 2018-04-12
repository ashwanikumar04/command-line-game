package in.ashwanik.clgame.messaging;

import java.util.List;

/**
 * Created by Ashwani Kumar on 12/04/18.
 */
public class Messenger {
    private static Messenger INSTANCE;
    private Broker broker;
    private static boolean initialized;

    private Messenger(Broker broker) {
        this.broker = broker;
    }

    public static void init(Broker broker) {
        if (!initialized) {
            INSTANCE = new Messenger(broker);
        } else {
            initialized = true;
        }
    }

    public static Messenger getInstance() {
        return INSTANCE;
    }

    public void subscribe(Subscriber subscriber, String topic) {
        broker.addSubscriber(topic, subscriber);
    }

    public void unsubscribe(Subscriber subscriber, String topic) {
        broker.removeSubscriber(topic, subscriber);
    }


    public void publish(Message message) {
        List<Subscriber> subscribers = broker.getSubscribersForTopic(message.getTopic());
        if (subscribers != null) {
            for (Subscriber subscriber : subscribers) {
                subscriber.receive(message);
            }
        }
    }
}
