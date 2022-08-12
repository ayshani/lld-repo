package org.logger.model;

import org.logger.enums.LogLevel;

import java.time.LocalDateTime;

public class Message {

    private LogLevel logLevel;
    private LocalDateTime epoch;
    private String message;
    private String nameSpace;

    public Message(LogLevel logLevel, LocalDateTime epoch, String message, String nameSpace) {
        this.logLevel = logLevel;
        this.epoch = epoch;
        this.message = message;
        this.nameSpace = nameSpace;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public LocalDateTime getEpoch() {
        return epoch;
    }

    public String getMessage() {
        return message;
    }

    public String getNameSpace() {
        return nameSpace;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public void setEpoch(LocalDateTime epoch) {
        this.epoch = epoch;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }

    @Override
    public String toString() {
        return "Message{" +
                "logLevel=" + logLevel +
                ", epoch=" + epoch +
                ", message='" + message + '\'' +
                ", nameSpace='" + nameSpace + '\'' +
                '}';
    }
}
