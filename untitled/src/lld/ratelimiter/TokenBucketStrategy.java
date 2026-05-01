package lld.ratelimiter;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Anirudh
 * @since 02/05/26
 */
public class TokenBucketStrategy implements RateLimiterStrategy {


    private final ConcurrentHashMap<String, TokenBucketInfo> userMap;
    private final int numOfTokens;
    // in mills
    private final int refillRate;

    public TokenBucketStrategy(int numOfTokens, int refillRate) {
        this.numOfTokens = numOfTokens;
        this.refillRate = refillRate;

        this.userMap = new ConcurrentHashMap<>();
    }


    @Override
    public boolean allowRequest(String key) {

        userMap.computeIfAbsent(key, k -> new TokenBucketInfo(this.numOfTokens, this.refillRate, System.currentTimeMillis(), this.numOfTokens));

        TokenBucketInfo bucketInfo = userMap.get(key);

        synchronized (bucketInfo) {
            checkAndRefill(bucketInfo);

            if (bucketInfo.currentTokens > 0) {
                bucketInfo.currentTokens--;
                return true;
            }

            return false;
        }


    }

    private void checkAndRefill(TokenBucketInfo bucketInfo) {

        long now = System.currentTimeMillis();

        long elapsedTime = now - bucketInfo.lastRefillTimestamp;
        int tokensToAdd = (int) (elapsedTime / bucketInfo.refillRate);

        if (tokensToAdd > 0) {
            bucketInfo.currentTokens = Math.min(
                    bucketInfo.capacity,
                    bucketInfo.currentTokens + tokensToAdd
            );

            bucketInfo.lastRefillTimestamp += (long) tokensToAdd * bucketInfo.refillRate;
        }


    }


    static class TokenBucketInfo {
        private final int capacity;
        private final int refillRate;
        private long lastRefillTimestamp;
        private int currentTokens;

        public TokenBucketInfo(int capacity, int refillRate, long lastRefillTimestamp, int currentTokens) {
            this.capacity = capacity;
            this.refillRate = refillRate;
            this.lastRefillTimestamp = lastRefillTimestamp;
            this.currentTokens = currentTokens;

        }
    }
}
