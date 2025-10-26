package lld.chainofresponsibility;

/**
 * @author Anirudh
 * @since 26/10/25
 */
public class Main {
    public static void main(String[] args) {
        LogProcessor logger = new InfoLogProcessor(new ErrorLogProcessor(new DebugLogProcessor(null)));

        logger.log(LogProcessor.INFO, "Info log!!");
        logger.log(LogProcessor.ERROR, "Error log!!");
        logger.log(LogProcessor.DEBUG, "Debug log!!");
    }
}
