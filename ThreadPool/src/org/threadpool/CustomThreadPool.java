package org.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class CustomThreadPool {

    private BlockingQueue<Runnable> taskQueue;
    private List<WorkerThread> workerThreads;
    private List<WorkerThreadRunnable> workerThreadsRunnable ;
    private AtomicBoolean isThreadShutDownInitiated;

    public CustomThreadPool(int threadPoolSize){
        workerThreads = new ArrayList<>(threadPoolSize);
        workerThreadsRunnable = new ArrayList<>(threadPoolSize);

        taskQueue = new LinkedBlockingQueue<>(); //Will Maintain the Order . ArrayBlocking Queue can be used also
        isThreadShutDownInitiated = new AtomicBoolean(false);

        // create working thread
        for(int i=0;i<threadPoolSize;i++){
            WorkerThread worker = new WorkerThread(taskQueue);
            WorkerThreadRunnable workerRunnable = new WorkerThreadRunnable(taskQueue);
            workerThreads.add(worker);
            workerThreadsRunnable.add(workerRunnable);
            //worker.start(); Either use This WorkerThread Or WorkerThreadRunnable
            new Thread(workerRunnable).start();
        }
    }

    public synchronized void execute(Runnable task) throws InterruptedException{
        if(!isThreadShutDownInitiated.get()){
            taskQueue.offer(task);
        } else
            throw new InterruptedException("Thread Pool shutdown is initiated, unable to execute task");
    }

    public synchronized void stop(){
        isThreadShutDownInitiated = new AtomicBoolean(true);
        for(WorkerThread worker : workerThreads){
            worker.doStop();
        }
        for(WorkerThreadRunnable worker : workerThreadsRunnable){
            worker.doStop();
        }
    }

    public synchronized void waitUtilAllTasksFinished(){
        while(!taskQueue.isEmpty()){
            try{
                Thread.sleep(1); //Wait so that worker can finish the currently executing Tasks
            } catch (InterruptedException e){

            }
        }
    }
}
