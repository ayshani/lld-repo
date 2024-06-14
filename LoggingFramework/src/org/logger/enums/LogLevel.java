package org.logger.enums;

import java.util.Arrays;
import java.util.Optional;

public enum LogLevel {

    SEVERE("SEVERE",7),
    WARNING("WARNING",6),
    INFO("INFO",5),
    CONFIG("CONFIG",4),
    FINE("FINE",3),
    FINNER("FINNER",2),
    FINEST("FINEST",1);

    private String logLevel;
    private int logLevelNumber;

    LogLevel(String logLevel, int logLevelNumber) {
        this.logLevel = logLevel;
        this.logLevelNumber = logLevelNumber;
    }

    public String getLogLevel(){
        return this.logLevel;
    }

    public int getLogLevelNumber(){
        return this.logLevelNumber;
    }

    public static LogLevel getLevelByName(String levelName){

        Optional<LogLevel> log =Arrays.stream(LogLevel.values()).filter(logLevel ->
                logLevel.getLogLevel().equals(levelName)).findFirst();

        if(!log.isPresent())
            return null;

        return log.get();

        /*
        for (LoggerLevel loggerLevel : LoggerLevel.values()) {
            if (loggerLevel.getLevel().equals(levelName)) { return loggerLevel; }
        }
        return null;
         */
    }
}
