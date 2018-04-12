package in.ashwanik.clgame.messaging;

import java.util.*;

public class Broker {
    private final Map<String, List<Subscriber>> subscribers;

    public Broker() {
        subscribers = new HashMap<>();
    }

    public List<Subscriber> getSubscribersForTopic(String topic) {
        synchronized (subscribers) {
            if ((topic != null && (topic.length() > 0))
                    && subscribers.containsKey(topic)) {
                return subscribers.get(topic);
            } else {
                return Collections.emptyList();
            }
        }
    }

    public void addSubscriber(String topic, Subscriber subscriber) {
        synchronized (subscribers) {
            if (topic != null && (topic.length() > 0)) {
                if (subscribers.containsKey(topic)) {
                    subscribers.get(topic).add(subscriber);
                } else {
                    List<Subscriber> subscribersList = new ArrayList<>();
                    subscribersList.add(subscriber);
                    subscribers.put(topic, subscribersList);
                }
            }
        }
    }

    public void removeSubscriber(String topic, Subscriber subscriber) {
        synchronized (subscribers) {
            if (topic != null && (topic.length() > 0)) {
                List<Subscriber> subscribersList = getSubscribersForTopic(topic);
                for (int index = 0; index < subscribersList.size(); index++) {
                    if (subscriber.getClass().equals(subscribersList.get(index).getClass())) {
                        subscribersList.remove(index);
                        break;
                    }
                }
            }
        }
    }
}
