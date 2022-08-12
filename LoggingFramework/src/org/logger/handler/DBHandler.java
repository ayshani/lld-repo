package org.logger.handler;

import org.logger.model.Message;

public class DBHandler implements Handler{
    @Override
    public void publish(Message message) {
        System.out.println("DBHandler: "+ message.getEpoch() +
                ": { "+ message.getLogLevel().getLogLevel() + " } :" +
                ": { "+ message.getNameSpace() +" }:" +
                message.getMessage());
    }
}
