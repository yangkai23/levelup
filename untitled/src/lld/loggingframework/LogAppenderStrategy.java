package lld.loggingframework;

import java.util.List;

/**
 * @author Anirudh
 * @since 24/11/26
 */
public interface LogAppenderStrategy {

    void append(List<LogEvent> logEvent);

    void append(LogEvent logEvent);
}
