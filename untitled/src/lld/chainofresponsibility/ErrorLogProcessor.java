package lld.chainofresponsibility;

/**
 * @author Anirudh
 * @since 26/10/25
 */
public class ErrorLogProcessor extends LogProcessor {

    public ErrorLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }

    @Override
    public void log(int logLevel, String message) {
        if (logLevel == ERROR) {
            System.err.println("ERROR : " + message);
        } else {
            super.log(logLevel, message);
        }
    }
}
