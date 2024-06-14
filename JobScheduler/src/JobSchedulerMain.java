import priorityqueue.Job;
import priorityqueue.JobPriority;
import priorityqueue.PriorityQueueScheduler;

public class JobSchedulerMain {

    private static int POOL_SIZE = 3;
    private static int QUEUE_SIZE = 10;

    public static void main(String[] args) {
        System.out.println("Job scheduler--------");

        Job job1 = new Job("Job1", JobPriority.LOW);
        Job job2 = new Job("Job2", JobPriority.MEDIUM);
        Job job3 = new Job("Job3", JobPriority.HIGH);
        Job job4 = new Job("Job4", JobPriority.MEDIUM);
        Job job5 = new Job("Job5", JobPriority.LOW);
        Job job6 = new Job("Job6", JobPriority.HIGH);

        PriorityQueueScheduler priorityQueueScheduler = new PriorityQueueScheduler(POOL_SIZE,QUEUE_SIZE);
        priorityQueueScheduler.scheduleJob(job1);
        priorityQueueScheduler.scheduleJob(job2);
        priorityQueueScheduler.scheduleJob(job3);
        priorityQueueScheduler.scheduleJob(job4);
        priorityQueueScheduler.scheduleJob(job5);
        priorityQueueScheduler.scheduleJob(job6);
        priorityQueueScheduler.scheduleJob(job4);

    }
}