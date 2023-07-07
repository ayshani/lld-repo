package com.router.service;

import com.router.model.Packet;
import com.router.util.RouterEvictionComparator;

import java.util.PriorityQueue;
import java.util.concurrent.locks.ReentrantLock;

public class Router {

    private PriorityQueue<Packet> incomingQueue;
    ReentrantLock reentrantLock;
    public Router(){
        reentrantLock = new ReentrantLock();
        incomingQueue = new PriorityQueue<>(new RouterEvictionComparator());

    }

    public void addPackets(Packet packet){
        packet.setInBoundTime(System.currentTimeMillis());
        reentrantLock.lock();
        try {
            System.out.println("At  time : " + System.currentTimeMillis() + " : Adding packet in Router queue: " + packet.getId());
            incomingQueue.offer(packet);
        } finally {
            reentrantLock.unlock();
        }
    }

    public void removePacketFromRouter(){
        reentrantLock.lock();
        try {
            if(!incomingQueue.isEmpty())
                System.out.println("At  time : "+ System.currentTimeMillis() +" : Removing packet from Router queue: "+ incomingQueue.poll());
        } finally {
            reentrantLock.unlock();
        }
    }
}
