package lld.loggingframework;

/**
 * @author Anirudh
 * @since 24/11/26
 */
public class LoggerTest {
    public static void main(String[] args) throws InterruptedException {


        LogAppenderStrategy strategy = LogAppenderStrategyFactory.getStrategy(AppenderType.CONSOLE);

        LogEventQueueHandler eventQueueHandler = new ArrayBlockingQueueEventHandler(10);

        LogConsumer consumer = new LogConsumer(eventQueueHandler, strategy);


        PaymentApp app = new PaymentApp(new LogDispatcher(eventQueueHandler));
        app.pay();

        consumer.startPolling();
            Thread.sleep(5000);



    }
}
