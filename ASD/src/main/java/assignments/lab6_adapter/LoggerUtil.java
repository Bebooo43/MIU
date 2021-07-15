package assignments.lab6_adapter;

public class LoggerUtil implements Logger{

    @Override
    public void log(LogLevel logLevel, String message) {
        System.out.println("["+logLevel.name()+"] "+message);
    }
}
