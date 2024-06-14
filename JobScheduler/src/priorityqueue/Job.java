package priorityqueue;

public class Job implements Runnable{

    private String name;
    private JobPriority jobPriority;

    public Job(String name, JobPriority jobPriority) {
        this.name = name;
        this.jobPriority = jobPriority;
    }

    public JobPriority getJobPriority() {
        return jobPriority;
    }

    @Override
    public void run() {
        System.out.println("Job : "+ name + " Priority :"+ jobPriority);
    }
}
