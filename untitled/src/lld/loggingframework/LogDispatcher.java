package lld.loggingframework;


/**
 * @author Anirudh
 * @since 24/11/26
 */

public class LogDispatcher {

    private final LogEventQueueHandler logEventQueueHandler;

    public LogDispatcher(LogEventQueueHandler logEventQueueHandler) {
        this.logEventQueueHandler = logEventQueueHandler;
    }

    public void dispatch(LogEvent logEvent) {

        boolean added = logEventQueueHandler.offer(logEvent);

        if (!added) {
            // Temporary rejection policy
            if (logEvent.level == LogLevel.DEBUG) {
                return;
            }

            System.err.println(
                    "Log event rejected: " + logEvent.message
            );
        }
    }
}

