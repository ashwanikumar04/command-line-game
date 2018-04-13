package in.ashwanik.clgame.messaging;

import in.ashwanik.clgame.messaging.messages.Message;
import in.ashwanik.clgame.utils.CollectionsUtil;

import java.util.List;

/**
 * Created by Ashwani Kumar on 12/04/18.
 */
public class EventBus {
    private static EventBus INSTANCE;
    private Broker broker;
    private static boolean initialized;

    private EventBus(Broker broker) {
        this.broker = broker;
    }

    public static void init(Broker broker) {
        if (!initialized) {
            INSTANCE = new EventBus(broker);
            initialized = true;
        }
    }

    public static EventBus getInstance() {
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
        if (!CollectionsUtil.isEmpty(subscribers)) {
            for (Subscriber subscriber : subscribers) {
                subscriber.receive(message);
            }
        }
    }
}
