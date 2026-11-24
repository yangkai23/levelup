package lld.loggingframework;

import java.util.List;

/**
 * @author Anirudh
 * @since 24/11/26
 */

public class LogConsumer {

    private final LogEventQueueHandler logEventQueueHandler;
    private final LogAppenderStrategy logAppenderStrategy;

    public LogConsumer(
            LogEventQueueHandler logEventQueueHandler,
            LogAppenderStrategy logAppenderStrategy) {

        this.logEventQueueHandler = logEventQueueHandler;
        this.logAppenderStrategy = logAppenderStrategy;
    }

    public void startPolling() {
        Thread worker = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                List<LogEvent> events =
                        logEventQueueHandler.consume(20);

                if (!events.isEmpty()) {
                    logAppenderStrategy.append(events);
                }
            }
        }, "log-consumer");

        worker.setDaemon(true);
        worker.start();
    }
}

