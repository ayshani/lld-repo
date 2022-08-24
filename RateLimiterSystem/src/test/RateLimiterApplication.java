package test;

import org.ratelimiter.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


//https://hechao.li/2018/06/25/Rate-Limiter-Part1/

//CountDown Latch : https://www.baeldung.com/java-countdown-latch
//Simply put, a CountDownLatch has a counter field, which you can decrement as we require.
//We can then use it to block a calling thread until it's been counted down to zero.

//If we were doing some parallel processing,
//we could instantiate the CountDownLatch with the same value for the counter as a number of threads
//we want to work across. Then, we could just call countdown() after each thread finishes,
//guaranteeing that a dependent thread calling await() will block until the worker threads are finished.

public class RateLimiterApplication {


    public static void main(String[] args) throws InterruptedException {
        final int MAX_REQUEST_PER_SECOND = 10;

        //RateLimiter rateLimiter = new TokenBucketNaive(MAX_REQUEST_PER_SECOND);
        //RateLimiter rateLimiter = new TokenBucketWithRefillRate(4, MAX_REQUEST_PER_SECOND);
        //RateLimiter rateLimiter = TokenBucketFactory.makeTokenBucketWithDaemonThread(4,MAX_REQUEST_PER_SECOND);
        //RateLimiter rateLimiter = new FixedWindowCounter(MAX_REQUEST_PER_SECOND);
        //RateLimiter rateLimiter = new SlidingWindowLog(MAX_REQUEST_PER_SECOND);
        RateLimiter rateLimiter = new SlidingWindowCounter(MAX_REQUEST_PER_SECOND);

        Thread requestThread = new Thread(() ->{
            sendRequest(rateLimiter, 10,1);
            sendRequest(rateLimiter, 20,2);
            sendRequest(rateLimiter, 50,5);
            sendRequest(rateLimiter, 100,10);
            sendRequest(rateLimiter, 200,20);
            sendRequest(rateLimiter, 250,25);
            sendRequest(rateLimiter, 500,50);
            sendRequest(rateLimiter, 1000,100);
        });

        requestThread.start();
        requestThread.join();

    }

    private static void sendRequest(RateLimiter rateLimiter, int totalCount, int requestPerSec) {
        long startTime = System.currentTimeMillis();
        CountDownLatch doneSignal = new CountDownLatch(totalCount);

        for(int i=0;i<totalCount;i++){
            try{
                new Thread(() -> {
                    while(!rateLimiter.allowRequest()){
                        try{
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    doneSignal.countDown();
                }).start();
                TimeUnit.MILLISECONDS.sleep(1000/requestPerSec);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            doneSignal.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        double duration = (System.currentTimeMillis() -startTime)/1000.0;

        System.out.println(totalCount + " requests processed in "+ duration + " seconds. "+
                "Rate : " + (double)totalCount/duration + " per second");
    }
}
