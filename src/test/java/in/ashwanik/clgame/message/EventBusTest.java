package in.ashwanik.clgame.message;

import in.ashwanik.clgame.UnitTest;
import in.ashwanik.clgame.messaging.Broker;
import in.ashwanik.clgame.messaging.EventBus;
import in.ashwanik.clgame.messaging.Message;
import in.ashwanik.clgame.messaging.Subscriber;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by Ashwani Kumar on 12/04/18.
 */
@Category(UnitTest.class)
public class EventBusTest {

    Subscriber testSubscriber = message -> {
        assertThat(message).isNotNull();
    };

    @Before
    public void setup() {
        EventBus.init(new Broker());
    }

    @Test
    public void Should_Subscribe_On_Topic() {
        EventBus.getInstance().subscribe(testSubscriber, "test");
    }

    @Test
    public void Should_UnSubscribe_On_Topic() {
        EventBus.getInstance().unsubscribe(testSubscriber, "test");
    }

    @Test
    public void Should_Publish_On_Topic() {
        EventBus.getInstance().subscribe(testSubscriber, "test");
        EventBus.getInstance().publish(Message.builder().payload("test").topic("test").build());
    }
}

