package lld.ratelimiter;

/**
 * @author Anirudh
 * @since 24/04/26
 */
public interface RateLimiterStrategy {

    boolean allowRequest(String key);
}
