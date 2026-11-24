package lld.loggingframework;

/**
 * @author Anirudh
 * @since 24/11/26
 */
public class PaymentApp {
    AppLogger logger;

    PaymentApp(LogDispatcher logDispatcher) {
        logger = LoggerFactory.getLogger("paymentApp", LogLevel.WARN, logDispatcher);
    }


    public void pay() {
        logger.debug("Payment processing started");

        logger.info("user details fetched");

        logger.warn("card expiring soon");


        logger.error("payment failed");
    }
}
