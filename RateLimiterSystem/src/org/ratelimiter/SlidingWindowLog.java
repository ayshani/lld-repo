package org.ratelimiter;

import java.util.LinkedList;
import java.util.Queue;

//https://hechao.li/2018/06/25/Rate-Limiter-Part1/
public class SlidingWindowLog extends RateLimiter{

    private final Queue<Long> log;
    public SlidingWindowLog(int maxRequestPerSec) {
        super(maxRequestPerSec);
        log = new LinkedList<>();
    }

    @Override
    public boolean allowRequest() {

        long currentTime = System.currentTimeMillis();
        long boundaryTime = currentTime -1; // one sec window

        synchronized (log){
            while(!log.isEmpty() && log.peek()<=boundaryTime){
                log.poll();
            }

            log.offer(currentTime);
            return log.size() <= MAX_TOKEN;
        }
    }
}
