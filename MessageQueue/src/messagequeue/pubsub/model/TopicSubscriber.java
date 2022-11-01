package messagequeue.pubsub.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@AllArgsConstructor
public class TopicSubscriber {
    private final AtomicInteger offset;
    private final ISubscriber subscriber;


    public TopicSubscriber(@NonNull ISubscriber subscriber) {
        this.offset = new AtomicInteger(0);
        this.subscriber = subscriber;
    }
}
