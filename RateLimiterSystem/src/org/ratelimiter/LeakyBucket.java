package org.ratelimiter;

import java.net.http.HttpRequest;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LeakyBucket {

    BlockingQueue<HttpRequest> queue;

    public LeakyBucket(int capacity){
        queue = new LinkedBlockingQueue<>(capacity);
    }

    public boolean allowRequest(HttpRequest request){

        if(queue.remainingCapacity()>0){
            queue.add(request);
            return true;
        }

        return false;
    }
}
