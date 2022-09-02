package org.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class WorkerThreadRunnable implements Runnable{

    private Thread thread;
    private BlockingQueue<Runnable> taskQueue;
    private AtomicBoolean isThreadShutDownInitiated;

    public WorkerThreadRunnable(BlockingQueue<Runnable> taskQueue){
        this.taskQueue =  taskQueue;
        this.isThreadShutDownInitiated =  new AtomicBoolean(false);
    }

    @Override
    public void run() {

        this.thread = Thread.currentThread();
        while(!isShutDownInitiated()){
            try{
                //take() – waits for a head element of a queue and removes it. If the queue is empty,
                //it blocks and waits for an element to become available

                //poll(long timeout, TimeUnit unit) – retrieves and removes the head of the queue,
                //waiting up to the specified wait time if necessary for an element to become available.
                // Returns null after a timeout
                Runnable task = taskQueue.take();
                task.run();
            } catch (InterruptedException e) {
                //log or otherwise report exception,
                //but keep pool thread alive.
            }
        }
    }

    public boolean isShutDownInitiated(){
        return isThreadShutDownInitiated.get();
    }


    public synchronized void doStop(){
        isThreadShutDownInitiated = new AtomicBoolean(true);
        //break pool thread out of dequeue() call.
        this.thread.interrupt();
    }
}
