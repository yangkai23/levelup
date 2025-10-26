package lld.chainofresponsibility;

/**
 * @author Anirudh
 * @since 26/10/25
 */
public class DebugLogProcessor extends LogProcessor {
    public DebugLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }

    @Override
    public void log(int logLevel, String message) {
        if (logLevel == DEBUG) {
            System.out.println("DEBUG : " + message);
        } else {
            super.log(logLevel, message);
        }
    }

}
