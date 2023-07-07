package com.router.service;

import com.router.model.Packet;
import com.router.util.RouterEvictionComparator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class Router {

    private volatile  static Router router;
    private PriorityBlockingQueue<Packet> incomingQueue;
    private ExecutorService singleRouterRunningThread ;
    private ExecutorService routerScheduler;

    public static Router getInstance(int poolSize, int initialCapacity){
        if(router == null) {
            synchronized (Router.class) {
                if (router == null) {
                    router = new Router(poolSize, initialCapacity);
                }
            }
        }
        return router;
    }
    private Router(int poolSize, int initialCapacity){
        singleRouterRunningThread = Executors.newSingleThreadExecutor();
        routerScheduler  = Executors.newFixedThreadPool(poolSize);
        incomingQueue = new PriorityBlockingQueue<Packet>(initialCapacity, new RouterEvictionComparator());
    }

    public void startRouter(){
        singleRouterRunningThread.execute(()->{
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            while(true){
                try {
                    routerScheduler.execute(incomingQueue.take());
                    Thread.sleep(20);
                } catch (InterruptedException e){
                    break;
                }
            }
        });
    }

    public void addPackets(Packet packet){
        packet.setInBoundTime(System.currentTimeMillis());
        System.out.println("At  time : " + System.currentTimeMillis() + " : Adding packet in Router queue: " + packet.getId());
        incomingQueue.offer(packet);

    }

}
