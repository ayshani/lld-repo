package org.logger.config;

import org.logger.enums.HandlerType;
import org.logger.enums.LogLevel;

import java.util.*;

public class LoggerConfiguration {

    private static volatile  LoggerConfiguration instance = null;

    private Map<LogLevel, Set<HandlerType>> logLevelHandlerTypeMap;

    private LogLevel globalLogLevel = null;

    private LoggerConfiguration(){
        logLevelHandlerTypeMap = new HashMap<>();
    }

    public static LoggerConfiguration getInstance(){
        if(instance == null){
            synchronized (LoggerConfiguration.class){
                if(instance==null){
                    instance = new LoggerConfiguration();
                } else
                    return instance;
            }
        }

        return instance;
    }


    public LogLevel getGlobalLogLevel() {
        return globalLogLevel;
    }

    public void setGlobalLogLevel(LogLevel globalLogLevel) {
        this.globalLogLevel = globalLogLevel;
    }

    public void addHandlerTypeToLogLevel(LogLevel level, HandlerType handlerType){
        if(level==null || handlerType==null)
            return;

        logLevelHandlerTypeMap.putIfAbsent(level,new HashSet<>())   ;
        logLevelHandlerTypeMap.get(level).add(handlerType);
    }

    public Set<HandlerType> getHandlerTypesByLoglevel(LogLevel logLevel){
        if(logLevel == null)
            return null;

        if(logLevelHandlerTypeMap.containsKey(logLevel))
        {
            return logLevelHandlerTypeMap.get(logLevel);
        } else{
            addHandlerTypeToLogLevel(logLevel,HandlerType.FILE);
        }
        return logLevelHandlerTypeMap.get(logLevel);
    }
}
