package lld.loggingframework;

import java.io.PrintStream;
import java.util.List;

/**
 * @author Anirudh
 * @since 24/11/26
 */
public class ConsoleLogAppenderStrategy implements LogAppenderStrategy {

    private final PrintStream output;


    public ConsoleLogAppenderStrategy(PrintStream output) {
        this.output = output;
    }

    @Override
    public void append(List<LogEvent> logEvents) {
        logEvents.stream().map(this::format).forEach(output::println);
    }

    @Override
    public void append(LogEvent logEvent) {
        append(List.of(logEvent));
    }


    private String format(LogEvent logEvent) {

        return logEvent.timestamp +
                " " +
                logEvent.level +
                " " +
                logEvent.loggerName +
                " " +
                logEvent.threadName +
                " " +
                logEvent.message;

    }
}
