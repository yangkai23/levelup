package lld.loggingframework;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Anirudh
 * @since 24/11/26
 */
public class LogAppenderStrategyFactory {


    private static final Map<AppenderType, LogAppenderStrategy> strategies;


    static {
        strategies = new HashMap<>();
        strategies.put(AppenderType.CONSOLE, new ConsoleLogAppenderStrategy(System.out));
    }



    public static LogAppenderStrategy getStrategy(AppenderType appenderType) {

        if (!strategies.containsKey(appenderType))
            throw new IllegalArgumentException("Invalid appender type: " + appenderType);
        return strategies.get(appenderType);
    }
}
