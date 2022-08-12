package org.logger.handler;

import org.logger.model.Message;

public interface Handler {

    void publish(Message message);
}
