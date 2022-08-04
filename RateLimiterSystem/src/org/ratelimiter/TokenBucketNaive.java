package org.ratelimiter;

public class TokenBucketNaive extends RateLimiter{

    private int possibleTokens;
    private long lastRequestTimestamp;
    public TokenBucketNaive(int maxToken) {
        super(maxToken);
        this.possibleTokens = 0;
        this.lastRequestTimestamp =  System.currentTimeMillis();
    }

    @Override
    synchronized public boolean allowRequest() {
        // once a request comes, refill the token bucket first.
        // lazy token filling.
        refillTokens();
        if(possibleTokens==0)
            return false;
        else{
            possibleTokens--;
        }
        this.lastRequestTimestamp = System.currentTimeMillis();
        return true;
    }

    private void refillTokens(){
        long now = System.currentTimeMillis();
        /*
        Assuming as of now, 1 token/sec is getting added
        We can add one reffil rate later
         */
        possibleTokens += ((now-lastRequestTimestamp)/1000)* this.MAX_TOKEN;

        possibleTokens = Math.min(possibleTokens,this.MAX_TOKEN);


    }
}
