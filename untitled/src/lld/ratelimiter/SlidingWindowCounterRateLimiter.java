package lld.ratelimiter;


import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Anirudh
 * @since 24/04/26
 */
public class SlidingWindowCounterRateLimiter implements RateLimiterStrategy {

    private final int limit;
    private final long windowSizeMillis;

    private final ConcurrentHashMap<String, SlidingWindow> storeMap = new ConcurrentHashMap<>();

    @Override
    public boolean allowRequest(String key) {

        long now = System.currentTimeMillis();

        long windowStart = (now / windowSizeMillis) * windowSizeMillis;

        storeMap.putIfAbsent(key, new SlidingWindow(windowStart));

        SlidingWindow window = storeMap.get(key);

        synchronized (window) {

            if (window.windowStart < windowStart) {
                window.previousCount = window.currentCount;
                window.currentCount = 0;
                window.windowStart = windowStart;
            }

            double overlap = (window.windowStart + windowSizeMillis - now) / (double) windowSizeMillis;

            double effectiveCount = window.currentCount + (window.previousCount * overlap);

            if (effectiveCount >= limit)

                return false;

            window.currentCount++;

            return true;

        }

    }

    public SlidingWindowCounterRateLimiter(int limit, long windowSizeMillis) {
        this.limit = limit;
        this.windowSizeMillis = windowSizeMillis;
    }

    /**
     * @author Anirudh
     * @since 24/04/26
     */
    public static class SlidingWindow {
        long windowStart;
        int currentCount;
        int previousCount;

        public SlidingWindow(long windowStart) {
            this.windowStart = windowStart;
            this.currentCount = 0;
            this.previousCount = 0;
        }
    }
}
