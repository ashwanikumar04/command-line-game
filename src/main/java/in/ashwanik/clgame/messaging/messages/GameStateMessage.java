package in.ashwanik.clgame.messaging.messages;

import lombok.Builder;
import lombok.Getter;

/**
 * Created by Ashwani Kumar on 13/04/18.
 */
@Getter
public class GameStateMessage extends Message {
    private Object payload;

    @Builder
    private GameStateMessage(String topic, String sender, String receiver, MessageType messageType, Object payload) {
        super(topic, sender, receiver, messageType);
        this.payload = payload;
    }

}
