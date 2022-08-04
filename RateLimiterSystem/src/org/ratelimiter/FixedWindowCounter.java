package org.ratelimiter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

// https://hechao.li/2018/06/25/Rate-Limiter-Part1/
public class FixedWindowCounter extends RateLimiter{

    // TODO: Clean up stale entries
    private final ConcurrentMap<Long, AtomicInteger> windows;
    public FixedWindowCounter(int maxRequestPerSec) {
        super(maxRequestPerSec);
        windows = new ConcurrentHashMap<>();
    }

    @Override
    public boolean allowRequest() {
        long windowKey = (long) (System.currentTimeMillis()/ 1e3); // sec
        windows.putIfAbsent(windowKey, new AtomicInteger(0));
        return windows.get(windowKey).getAndIncrement() <= MAX_TOKEN;
    }
}
