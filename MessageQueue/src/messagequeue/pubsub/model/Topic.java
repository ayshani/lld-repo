package messagequeue.pubsub.model;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Topic {

    private final String topicName;
    private final String topicId;
    private final List<Message> messages;
    private final List<TopicSubscriber> topicSubscribers;


    public Topic(@NonNull String topicName, @NonNull String topicId) {
        this.topicName = topicName;
        this.topicId = topicId;
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
