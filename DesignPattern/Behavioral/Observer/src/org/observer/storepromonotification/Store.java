package org.observer.storepromonotification;

public class Store {

    private final Subject notificationService;


    public Store() {
        notificationService = new NotificationService();
    }

    public void addNewItem(){
        notificationService.notifyListeners(EventType.NEW_ITEM);
    }

    public void addNewSale(){
        notificationService.notifyListeners(EventType.SALE);
    }

    public Subject getNotificationService() {
        return notificationService;
    }
}
