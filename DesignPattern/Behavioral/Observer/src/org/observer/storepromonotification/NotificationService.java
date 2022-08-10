package org.observer.storepromonotification;

import java.util.*;

//This is the concrete implementation of subject aka Publisher
public class NotificationService implements Subject{

    private Map<EventType, List<Listener>>  listenersByEventType;

    public NotificationService() {
        this.listenersByEventType = new HashMap<>();

        Arrays.stream(EventType.values()).forEach(event -> listenersByEventType.put(event,new ArrayList<>()));
    }

    @Override
    public void subscribe(EventType eventType, Listener listener) {
        listenersByEventType.get(eventType).add(listener);
    }

    @Override
    public void unsubscribe(EventType eventType, Listener listener) {
        listenersByEventType.get(eventType).remove(listener);
    }

    @Override
    public void notifyListeners(EventType eventType) {
        listenersByEventType.get(eventType).forEach(listener -> listener.update(eventType));
    }
}
