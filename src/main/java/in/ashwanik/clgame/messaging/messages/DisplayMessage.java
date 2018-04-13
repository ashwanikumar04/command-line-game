package in.ashwanik.clgame.messaging.messages;

import lombok.Builder;
import lombok.Getter;

/**
 * Created by jh80 on 13/04/18.
 */
@Getter
public class DisplayMessage extends Message {
    private Object payload;

    @Builder
    private DisplayMessage(String topic, String sender, String receiver, MessageType messageType, Object payload) {
        super(topic, sender, receiver, messageType);
        this.payload = payload;
    }

}
