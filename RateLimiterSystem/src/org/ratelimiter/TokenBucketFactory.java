package org.ratelimiter;

public class TokenBucketFactory{

    private TokenBucketFactory() {
    }

    public static TokenBucketWithDaemonThread makeTokenBucketWithDaemonThread(int refillRate, int MAX_TOKEN){
        TokenBucketWithDaemonThread tokenBucketWithDaemonThread = new TokenBucketWithDaemonThread(MAX_TOKEN,refillRate);
        tokenBucketWithDaemonThread.initialize();
        return tokenBucketWithDaemonThread;
    }

    private static class TokenBucketWithDaemonThread extends RateLimiter{

        private int refillRate;
        private int possibleTokens;
         private final static int ONE_SECOND = 1000;
        public TokenBucketWithDaemonThread(int MAX_TOKEN, int refillRate) {
            super(MAX_TOKEN);
            this.refillRate = refillRate;
            this.possibleTokens = 0;
        }

        public void initialize(){
            Thread daemonThread = new Thread(this::refill);
            daemonThread.setDaemon(true);
            daemonThread.start();
        }

        private void refill() {
            // Always try to refill token
            while(true){
                synchronized (this) {
                    // Add token as per refill rate
                    possibleTokens = Math.min(possibleTokens+refillRate,MAX_TOKEN);
                    //this.notifyAll(); // once refilled, notify all consumers
                }

                // Sleep for 1 sec, then wake up and add token
                try{
                    Thread.sleep(ONE_SECOND);
                } catch (InterruptedException e) {
                    // swallow exception
                }
            }
        }

        @Override
        public boolean allowRequest() {

            synchronized (this) {
                if(possibleTokens==0)
                    return false;

                possibleTokens--;
            }
            return true;
        }

        /*
        this method is similar to allowRequest
        Here Consumer will wait if there is no token , and will be notified by Daemon Thread after adding token
        So No immediate return in case of zero token

         */
        public void getToken() throws InterruptedException {

            synchronized (this) {
                while (possibleTokens == 0) {
                    this.wait();
                }
                possibleTokens--;
            }

            System.out.println(
                    "Granting " + Thread.currentThread().getName() + " token at " + System.currentTimeMillis() / 1000);
        }
    }
}

