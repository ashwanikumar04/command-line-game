package in.ashwanik.clgame;

import in.ashwanik.clgame.commands.InputStreamCommandParser;
import in.ashwanik.clgame.messaging.EventBus;
import in.ashwanik.clgame.messaging.Subscriber;
import in.ashwanik.clgame.messaging.Topics;
import in.ashwanik.clgame.messaging.messages.CommandMessage;
import in.ashwanik.clgame.messaging.messages.Message;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.experimental.categories.Category;

import java.io.IOException;
import java.util.ArrayList;

import static in.ashwanik.clgame.TestData.initBaseData;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * Created by Ashwani Kumar on 15/04/18.
 */
@Category(UnitTest.class)
public class TestInputStreamCommandParser {
    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();

    @Before
    public void setupTest() throws IOException {
        initBaseData(new ArrayList<>());
        Game.reset();
    }

    private Subscriber subscriber = new Subscriber() {
        @Override
        public void receive(Message message) {
            assertThat(((CommandMessage) message).getPayload().getCommand()).isEqualTo("help");
            EventBus.getInstance().unsubscribe(subscriber, Topics.COMMAND);
        }
    };

    @Test
    public void Should_Help_Command_IO() {
        systemInMock.provideLines("help");
        EventBus.getInstance().subscribe(subscriber, Topics.COMMAND);
        InputStreamCommandParser inputStreamCommandParser = new InputStreamCommandParser(System.in);
        inputStreamCommandParser.publishIssuesCommand();
    }

}
