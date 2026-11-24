package lld.loggingframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Anirudh
 * @since 24/11/26
 */
public class LoggerFactory {

    final static Map<String, AppLogger> loggers = new ConcurrentHashMap<>();


    public static AppLogger getLogger(String appName, LogLevel minLogLevel, LogDispatcher logDispatcher) {
        if (loggers.containsKey(appName))
            return loggers.get(appName);

        AppLogger logger = new AppLogger(minLogLevel, appName, logDispatcher);
        loggers.put(appName, logger);

        return logger;
    }

}
