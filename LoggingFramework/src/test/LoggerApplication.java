package test;

import org.logger.Logger;
import org.logger.config.LoggerConfiguration;
import org.logger.enums.HandlerType;
import org.logger.enums.LogLevel;

//https://github.com/kumaransg/LLD/blob/main/Low_level_Design_Problems/designLogger/MainClientRunner.java
public class LoggerApplication {
    public static void main(String[] args) {
        // Create Logger Instance
        Logger logger = Logger.getInstance();

        logger.addGlobalLogLevel(LogLevel.FINNER);

        logger.addHandlerTypeToLogLevel(LogLevel.SEVERE,HandlerType.FILE);
        logger.addHandlerTypeToLogLevel(LogLevel.SEVERE,HandlerType.CONSOLE);

        logger.addHandlerTypeToLogLevel(LogLevel.INFO,HandlerType.DB);
        logger.addHandlerTypeToLogLevel(LogLevel.INFO,HandlerType.CONSOLE);

        logger.addHandlerTypeToLogLevel(LogLevel.FINEST,HandlerType.DB);
        logger.addHandlerTypeToLogLevel(LogLevel.FINEST,HandlerType.CONSOLE);

        logger.log("Hello SEVERE Log",LogLevel.SEVERE, String.valueOf(LoggerApplication.class));
        // FINNEST will not print as global log level is FINER
        logger.log("Hello FINNEST Log",LogLevel.FINEST, String.valueOf(LoggerApplication.class));
        logger.log("Hello INFO Log",LogLevel.INFO, String.valueOf(LoggerApplication.class));
        // Default is File Handler
        logger.log("Hello FINNER Log",LogLevel.FINNER, String.valueOf(LoggerApplication.class));
    }
}
