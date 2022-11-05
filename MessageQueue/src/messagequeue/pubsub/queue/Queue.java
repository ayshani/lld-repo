package messagequeue.pubsub.queue;

import lombok.NonNull;
import messagequeue.pubsub.handler.TopicHandler;
import messagequeue.pubsub.model.ISubscriber;
import messagequeue.pubsub.model.Message;
import messagequeue.pubsub.model.Topic;
import messagequeue.pubsub.model.TopicSubscriber;

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

    public void subscribe(@NonNull final ISubscriber subscriber, @NonNull final Topic topic){
        // Most important line. All class has-a relationship
        topic.addSubscriber(new TopicSubscriber(subscriber));
        System.out.println(subscriber.getId() +" subscribed to topic : "+ topic.getTopicName());
    }

    public void publish(@NonNull final Topic topic, @NonNull final Message message){
        topic.addMessage(message);
        System.out.println(message.getMessage() + " published to topic : "+ topic.getTopicName());
        // create a new thread for handling the topic handler of specific topice
        // for not blocking the main thread
        new Thread(() -> topicProcessors.get(topic.getTopicId()).publish()).start();
    }

    public void resetOffset(@NonNull final Topic topic, @NonNull final ISubscriber subscriber, @NonNull final Integer newOffset){
        for(TopicSubscriber topicSubscriber : topic.getTopicSubscribers()){
            if(topicSubscriber.getSubscriber().equals(subscriber)){
                topicSubscriber.getOffset().set(newOffset);
                System.out.println(topicSubscriber.getSubscriber().getId() +" offset set to : "+ newOffset);
                new Thread(() -> topicProcessors.get(topic.getTopicId()).startSubscriberWorker(topicSubscriber)).start();
                break;
            }
        }
    }

}
