package test;

import messagequeue.pubsub.model.Message;
import messagequeue.pubsub.model.SleepingSubscriber;
import messagequeue.pubsub.model.Topic;
import messagequeue.pubsub.queue.Queue;


public class MessageQueueApp {
    public static void main(String[] args) throws InterruptedException {

        final Queue queue = new Queue();
        final Topic topic1 = queue.createTopic("Topic1");
        final Topic topic2 = queue.createTopic("Topic2");
        final SleepingSubscriber subscribe1 = new SleepingSubscriber("subscriber1",10000);
        final SleepingSubscriber subscribe2 = new SleepingSubscriber("subscriber2",20000);

        queue.subscribe(subscribe1,topic1);
        queue.subscribe(subscribe2,topic1);

        final SleepingSubscriber subscribe3 = new SleepingSubscriber("subscriber3",5000);
        queue.subscribe(subscribe3,topic2);

        queue.publish(topic1, new Message("Message1"));
        queue.publish(topic1, new Message("Message2"));

        queue.publish(topic2, new Message("Message3"));

        Thread.sleep(15000);

        queue.publish(topic2, new Message("Message4"));
        queue.publish(topic1, new Message("Message5"));

        queue.resetOffset(topic1,subscribe1,0);
    }
}