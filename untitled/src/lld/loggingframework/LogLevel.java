package lld.loggingframework;

/**
 * @author Anirudh
 * @since 24/11/26
 */
public enum LogLevel {

    DEBUG(1), INFO(2), WARN(3), ERROR(4);

    private final int severity;

    LogLevel(int severity) {
        this.severity = severity;
    }

    public boolean isHigherThanEqual(LogLevel other) {
        return this.severity >= other.severity;
    }
}
