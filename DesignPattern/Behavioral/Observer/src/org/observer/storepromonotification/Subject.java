package org.observer.storepromonotification;

public interface Subject {

    public void subscribe(EventType eventType, Listener listener);
    public void unsubscribe(EventType eventType, Listener listener);
    public void notifyListeners(EventType eventType);
}
