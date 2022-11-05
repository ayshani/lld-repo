package messagequeue.pubsub.queue;

import lombok.NonNull;
import messagequeue.pubsub.handler.TopicHandler;
import messagequeue.pubsub.model.Topic;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Queue {
    private final Map<String , TopicHandler> topicProcessors;

    public Queue(){
        topicProcessors = new HashMap<>();
    }

    public Topic createTopic(@NonNull final String topicName){
        final Topic topic = new Topic(topicName);
        TopicHandler topicHandler = new TopicHandler(topic);
        topicProcessors.put(topic.getTopicId(), topicHandler);
        System.out.println("Created Topic : "+ topic.getTopicName());
        return topic;
    }

    public void sub

}
