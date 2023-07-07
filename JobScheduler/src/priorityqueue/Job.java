package priorityqueue;

public class Job implements Runnable{

    private String name;
    private JobPriority jobPriority;

    public Job(String name, JobPriority jobPriority) {
        this.name = name;
        this.jobPriority = jobPriority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JobPriority getJobPriority() {
        return jobPriority;
    }

    public void setJobPriority(JobPriority jobPriority) {
        this.jobPriority = jobPriority;
    }

    @Override
    public void run() {
        System.out.println("Job : "+ name + " Priority :"+ jobPriority);
    }
}
