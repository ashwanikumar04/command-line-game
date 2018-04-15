package in.ashwanik.clgame.messaging;

import in.ashwanik.clgame.Game;
import in.ashwanik.clgame.messaging.messages.Message;
import in.ashwanik.clgame.ui.DisplayEngine;
import in.ashwanik.clgame.utils.CollectionsUtil;

import java.util.List;

/**
 * Created by Ashwani Kumar on 12/04/18.
 */
public class EventBus {
    private static EventBus INSTANCE;
    private static boolean initialized;
    private Broker broker;

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
        if (Game.isDebug()) {
            DisplayEngine.getDisplay().displayInWhite("\nMessage is published on " + message.getTopic() + ", message type: " + message.getMessageType());
        }
        List<Subscriber> subscribers = broker.getSubscribersForTopic(message.getTopic());
        if (!CollectionsUtil.isEmpty(subscribers)) {
            for (int index = 0; index < subscribers.size(); index++) {
                subscribers.get(index).receive(message);
            }
        }
    }
}
