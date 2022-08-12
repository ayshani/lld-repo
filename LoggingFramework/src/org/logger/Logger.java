package org.logger;

import lombok.NonNull;
import org.logger.config.LoggerConfiguration;
import org.logger.enums.HandlerType;
import org.logger.enums.LogLevel;
import org.logger.handler.Handler;
import org.logger.handler.HandlerContext;
import org.logger.model.Message;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.logging.LoggingPermission;

public class Logger {

    private static Logger instance;
    private static LoggerConfiguration loggerConfiguration;

    private Logger(){
        loggerConfiguration = LoggerConfiguration.getInstance();
    }

    public static Logger getInstance(){
        if(instance == null){
            synchronized (Logger.class){
                if(instance== null)
                {
                    instance = new Logger();
                    return instance;
                }
                else
                    return instance;
            }
        }
        return instance;
    }

    // Add log level
    public void addGlobalLogLevel(LogLevel globalLogLevel){
        loggerConfiguration.setGlobalLogLevel(globalLogLevel);
    }

    public void addHandlerTypeToLogLevel(LogLevel logLevel, HandlerType handlerType){
        loggerConfiguration.addHandlerTypeToLogLevel(logLevel,handlerType);
    }

    public void log(@NonNull final String message, @NonNull final LogLevel logLevel, @NonNull final String nameSpace){
        LogLevel globalLoglevel = loggerConfiguration.getGlobalLogLevel();

        if(logLevel.getLogLevelNumber() >= globalLoglevel.getLogLevelNumber()){
            Set<HandlerType> handlerTypes = loggerConfiguration.getHandlerTypesByLoglevel(logLevel);

            for( HandlerType handlerType : handlerTypes){
                Handler handler = HandlerContext.getRegisteredHandler(handlerType);
                Message messageObj = new Message(logLevel, LocalDateTime.now(),message,nameSpace);

                handler.publish(messageObj);
            }
        }
    }
}
