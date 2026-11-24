package lld.loggingframework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Anirudh
 * @since 24/11/26
 */

public class ArrayBlockingQueueEventHandler implements LogEventQueueHandler {

    private final BlockingQueue<LogEvent> logEventQueue;

    public ArrayBlockingQueueEventHandler(int capacity) {
        this.logEventQueue = new ArrayBlockingQueue<>(capacity);
    }

    @Override
    public boolean offer(LogEvent logEvent) {
        return logEventQueue.offer(logEvent);
    }

    @Override
    public boolean offer(LogEvent logEvent, long timeout, TimeUnit unit)
            throws InterruptedException {
        return logEventQueue.offer(logEvent, timeout, unit);
    }

    @Override
    public List<LogEvent> consume(int batchSize) {
        if (batchSize <= 0) {
            throw new IllegalArgumentException("Batch size must be positive");
        }

        List<LogEvent> batch = new ArrayList<>(batchSize);

        try {
            // Wait for the first event
            batch.add(logEventQueue.take());

            // Drain any additional available events
            logEventQueue.drainTo(batch, batchSize - 1);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return batch;
    }

    @Override
    public LogEvent consume() {
        List<LogEvent> batch = consume(1);
        return batch.isEmpty() ? null : batch.getFirst();
    }
}

