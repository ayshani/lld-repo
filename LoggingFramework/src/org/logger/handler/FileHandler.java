package org.logger.handler;

import org.logger.model.Message;

public class FileHandler implements Handler{

    @Override
    public void publish(Message message) {
        System.out.println("FileHandler: "+ message.getEpoch() +
                ": { "+ message.getLogLevel().getLogLevel() + " } :" +
                ": { "+ message.getNameSpace() +" }:" +
                message.getMessage());
    }
}
