package lld.loggingframework;

import java.util.Objects;

/**
 * @author Anirudh
 * @since 24/11/26
 */

public class LogEvent {

    public final LogLevel level;
    public final String message;
    public final String threadName;
    public final long timestamp;
    public final String loggerName;

    public LogEvent(
            LogLevel level,
            String message,
            String threadName,
            long timestamp,
            String loggerName) {

        this.level = level;
        this.message = message;
        this.threadName = threadName;
        this.timestamp = timestamp;
        this.loggerName = loggerName;
    }
}

