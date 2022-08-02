package test;

import org.ratelimiter.RateLimiter;
import org.ratelimiter.TokenBucket;

public class RateLimiterApplication {

    public static void main(String[] args) {
        int MAX_REQUEST_PER_SECOND = 10;
        RateLimiter rateLimiter = new TokenBucket(MAX_REQUEST_PER_SECOND);



    }
}
