package in.ashwanik.clgame.messaging;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Message {
    private String topic;
    private String sender;
    private String receiver;
    private long sentOn;
    private long receivedOn;
    private Object payload;
}
