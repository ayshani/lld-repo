package messagequeue.pubsub.model;

public class SleepingSubscriber implements ISubscriber{

    private final String id;
    private final int sleepTimeInMillis;

    public SleepingSubscriber(String id, int sleepTimeInMillis) {
        this.id = id;
        this.sleepTimeInMillis = sleepTimeInMillis;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void consume(Message message) throws InterruptedException {
        System.out.println("Subscriber " + id +" started consuming message : "+ message.getMessage());
        Thread.sleep(this.sleepTimeInMillis); // consumes takes time
        System.out.println("Subscriber " + id +" done consuming message : "+ message.getMessage());
    }
}
