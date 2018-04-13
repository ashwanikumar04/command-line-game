package in.ashwanik.clgame.messaging.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by jh80 on 13/04/18.
 */
@AllArgsConstructor
@Getter
public class Message {
    private String topic;
    private String sender;
    private String receiver;
    private MessageType messageType;
}
