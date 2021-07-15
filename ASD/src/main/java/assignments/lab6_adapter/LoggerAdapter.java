package assignments.lab6_adapter;

import org.apache.logging.log4j.LogManager;

import static org.apache.logging.log4j.LogManager.getLogger;

public class LoggerAdapter implements Logger {

    //public LoggerAdapter(org.apache.logging.log4j.Logger log4j) { this.log4j = log4j; }

    @Override
    public void log(LogLevel logLevel, String message) {
        org.apache.logging.log4j.Logger log4j = LogManager.getLogger();
        if(logLevel == LogLevel.DEBUG)
            log4j.debug(message);
        else if(logLevel == LogLevel.ERROR)
            log4j.error(message);
        else if(logLevel == LogLevel.FATAL)
            log4j.fatal(message);
        else if(logLevel == LogLevel.INFO)
            log4j.info(message);
        else if(logLevel == LogLevel.TRACE)
            log4j.trace(message);
        else if(logLevel == LogLevel.WARNING)
            log4j.warn(message);
    }
}
