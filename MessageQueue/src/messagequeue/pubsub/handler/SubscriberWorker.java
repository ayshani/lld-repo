package messagequeue.pubsub.handler;

import lombok.Getter;
import lombok.SneakyThrows;
import messagequeue.pubsub.model.Message;
import messagequeue.pubsub.model.Topic;
import messagequeue.pubsub.model.TopicSubscriber;

@Getter
public class SubscriberWorker implements Runnable{

    private final Topic topic;
    private final TopicSubscriber topicSubscriber;

    public SubscriberWorker(Topic topic, TopicSubscriber topicSubscriber) {
        this.topic = topic;
        this.topicSubscriber = topicSubscriber;
    }

    @SneakyThrows // sneaky throw concept allows us to throw any checked exception without defining it explicitly in the method signature.
    @Override
    public void run() {
        synchronized (topicSubscriber){
            do{
                int currentOffSet = topicSubscriber.getOffset().get();
                while(currentOffSet >= topic.getMessages().size()){
                    topicSubscriber.wait();
                }
                Message message = topic.getMessages().get(currentOffSet);
                topicSubscriber.getSubscriber().consume(message);

                // We cannot just increment here since subscriber offset can be reset while it is consuming.
                // Reset can happen from Queue which changes the offset.
                // So, after consuming we need to increase only if it was previous one.
                topicSubscriber.getOffset().compareAndSet(currentOffSet,currentOffSet+1);
            } while (true);
        }
    }

    synchronized public void wakeUpIfNeeded(){
        synchronized (topicSubscriber){
            topicSubscriber.notify();
        }
    }
}
