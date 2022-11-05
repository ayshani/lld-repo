package messagequeue.pubsub.model;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class Topic {

    private final String topicName;
    private final String topicId;
    private final List<Message> messages;
    private final List<TopicSubscriber> topicSubscribers;


    public Topic(@NonNull String topicName) {
        this.topicName = topicName;
        this.topicId = UUID.randomUUID().toString();
        this.messages = new ArrayList<>();
        this.topicSubscribers = new ArrayList<>();
    }

    public synchronized  void addMessage(@NonNull final Message message){
        messages.add(message);
    }

    public void addSubscriber(@NonNull final TopicSubscriber subscriber){
        topicSubscribers.add(subscriber);
    }
}
