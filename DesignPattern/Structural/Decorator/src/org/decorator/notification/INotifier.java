package org.decorator.notification;

public interface INotifier {

    void send(String message);
    String getUserName();
}
