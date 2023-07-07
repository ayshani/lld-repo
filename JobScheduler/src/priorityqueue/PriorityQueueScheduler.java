package priorityqueue;

import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityQueueScheduler {

    private ExecutorService priorityJobScheduler = Executors.newSingleThreadExecutor();
    private PriorityBlockingQueue<Job> priorityBlockingQueue;

    public PriorityQueueScheduler(int poolSize, Integer queueSize){
        ExecutorService executorService = Executors.newFixedThreadPool(poolSize);
        priorityBlockingQueue =  new PriorityBlockingQueue<>
                (queueSize, Comparator.comparing(Job::getJobPriority));

        priorityJobScheduler.execute(
                ()->{
                    while(true) {
                        try {
                            executorService.execute(priorityBlockingQueue.take());
                        } catch (InterruptedException e) {
                            break;
                        }
                    }
                }
        );
    }

        public void scheduleJob(Job job){
            priorityBlockingQueue.add(job);
        }
}
