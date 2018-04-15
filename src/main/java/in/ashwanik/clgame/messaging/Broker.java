package in.ashwanik.clgame.messaging;

import in.ashwanik.clgame.utils.StringUtils;

import java.util.*;

public class Broker {
    private final Map<String, List<Subscriber>> subscribers;

    public Broker() {
        subscribers = new HashMap<>();
    }

    List<Subscriber> getSubscribersForTopic(String topic) {
        synchronized (subscribers) {
            if (!StringUtils.isBlank(topic)
                    && subscribers.containsKey(topic)) {
                return subscribers.get(topic);
            } else {
                return Collections.emptyList();
            }
        }
    }

    void addSubscriber(String topic, Subscriber subscriber) {
        synchronized (subscribers) {
            if (!StringUtils.isBlank(topic)) {
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

    void removeSubscriber(String topic, Subscriber subscriber) {
        if (Objects.isNull(subscriber)) {
            return;
        }
        synchronized (subscribers) {
            if (!StringUtils.isBlank(topic)) {
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
