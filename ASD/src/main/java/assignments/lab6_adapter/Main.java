package assignments.lab6_adapter;

import org.apache.logging.log4j.LogManager;

public class Main {

    public static void main(final String... args) {
        Logger adapter = new LoggerAdapter();
        adapter.log(LogLevel.ERROR,"LoggerAdapter Message");

        Logger loggerUtil = new LoggerUtil();
        loggerUtil.log(LogLevel.ERROR,"LoggerUtil Message");
    }
}
