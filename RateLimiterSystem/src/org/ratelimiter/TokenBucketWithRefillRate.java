package org.ratelimiter;

public class TokenBucketWithRefillRate extends RateLimiter{

    private int refillRate;
    private int possibleTokens;
    private long lastRequestTimeStamp;

    public TokenBucketWithRefillRate(int refillRate, int MAX_TOKEN) {
        super(MAX_TOKEN);
        this.refillRate = refillRate;
        this.possibleTokens = 0;
        this.lastRequestTimeStamp = System.currentTimeMillis();
    }

    @Override
    synchronized  public boolean allowRequest() {
        refillToken();

        if(possibleTokens==0)
            return false;
        else
            possibleTokens--;
        this.lastRequestTimeStamp =  System.currentTimeMillis();

        return true;
    }

    private void refillToken() {
        long currentTime = System.currentTimeMillis();
        // time elapsed in seconds*refillRate
        possibleTokens += ((currentTime - lastRequestTimeStamp)/1000)*refillRate;

        possibleTokens =  Math.min(possibleTokens,MAX_TOKEN);
    }
}
