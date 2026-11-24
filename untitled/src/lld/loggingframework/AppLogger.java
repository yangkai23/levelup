package lld.loggingframework;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Anirudh
 * @since 24/11/26
 */
public class AppLogger {

    private final LogLevel level;
    private final String loggerName;
    private final AtomicInteger eventId = new AtomicInteger(5000);
    private final LogDispatcher dispatcher;

    public AppLogger(LogLevel level, String loggerName, LogDispatcher dispatcher) {
        this.level = level;
        this.loggerName = loggerName;
        this.dispatcher = dispatcher;

    }

    public void info(String message) {
        if (LogLevel.INFO.isHigherThanEqual(level)) {
            log(message, LogLevel.INFO);
        }

    }

    public void error(String message) {
        if (LogLevel.ERROR.isHigherThanEqual(level)) {
            log(message, LogLevel.ERROR);
        }
    }

    public void debug(String message) {
        if (LogLevel.DEBUG.isHigherThanEqual(level)) {
            log(message, LogLevel.DEBUG);
        }
    }

    public void warn(String message) {
        if (LogLevel.WARN.isHigherThanEqual(level)) {
            log(message, LogLevel.WARN);
        }
    }

    private void log(String message, LogLevel level) {
        LogEvent logEvent = new LogEvent(level, message, Thread.currentThread().getName(), System.currentTimeMillis(), loggerName);
        dispatcher.dispatch(logEvent);
    }

}
