package org.ratelimiter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

//https://hechao.li/2018/06/25/Rate-Limiter-Part1/

public class SlidingWindowCounter extends RateLimiter{

    private final ConcurrentMap<Long, AtomicInteger> windows ;
    public SlidingWindowCounter(int maxRequestPerSec) {
        super(maxRequestPerSec);
        windows = new ConcurrentHashMap<>();
    }

    @Override
    public boolean allowRequest() {
        long currentTime = System.currentTimeMillis();

        long currentWindowKey = currentTime/1000;

        windows.putIfAbsent(currentWindowKey,new AtomicInteger(0));
        long previousWindowKey = currentWindowKey -1;

        AtomicInteger previousWindowCount = windows.get(previousWindowKey);

        if(previousWindowCount == null){
            return windows.get(currentWindowKey).getAndIncrement() <= MAX_TOKEN;
        }

        long currentWindowOverlapTime = currentTime - (currentWindowKey*1000);

        double previousWindowOverlapPercentage = (1000 - currentWindowOverlapTime) /1000.0;

        long requestCountInCurrentSlidingWindow = (long)(previousWindowCount.get()* previousWindowOverlapPercentage
                                                    + windows.get(currentWindowKey).getAndIncrement());

        return requestCountInCurrentSlidingWindow <= MAX_TOKEN;

    }
}
