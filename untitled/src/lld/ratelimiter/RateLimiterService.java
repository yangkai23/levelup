package lld.ratelimiter;

/**
 * @author Anirudh
 * @since 24/04/26
 */
public class RateLimiterService {

    private final RateLimiterStrategy rateLimiterStrategy;

    public RateLimiterService(RateLimiterStrategy rateLimiterStrategy) {
        this.rateLimiterStrategy = rateLimiterStrategy;
    }

    public boolean isAllowed(String key) {
        return rateLimiterStrategy.allowRequest(key);
    }
}
