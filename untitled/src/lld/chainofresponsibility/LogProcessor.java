package lld.chainofresponsibility;

/**
 * @author Anirudh
 * @since 26/10/25
 */
public abstract class LogProcessor {
    public final static int INFO = 1;
    public final static int DEBUG = 2;
    public final static int ERROR = 3;
    private LogProcessor nextLogProcessor;

    public LogProcessor(LogProcessor logProcessor) {
        this.nextLogProcessor = logProcessor;
    }

    public void log(int logLevel, String logMessage) {
        if (nextLogProcessor != null)
            nextLogProcessor.log(logLevel, logMessage);
    }
}
