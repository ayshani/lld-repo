package org.logger.handler;

import org.logger.model.Message;

public class ConsoleHandler implements Handler{
    @Override
    public void publish(Message message) {
        System.out.println("ConsoleHandler: "+ message.getEpoch() +
                ": { "+ message.getLogLevel().getLogLevel() + " } :" +
                ": { "+ message.getNameSpace() +" }:" +
                message.getMessage());
    }
}
