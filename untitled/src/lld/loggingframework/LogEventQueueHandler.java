package lld.loggingframework;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Anirudh
 * @since 24/11/26
 */
public interface LogEventQueueHandler {

    boolean offer(LogEvent logEvent);

    boolean offer(LogEvent logEvent, long timeout, TimeUnit unit) throws InterruptedException;

    List<LogEvent> consume(int batchSize);

    LogEvent consume();
}
