package org.observer.storepromonotification;

//https://github.com/geekific-official/geekific-youtube/blob/main/pattern-behavioral-observer/src/com/youtube/geekific/MainApp.java
public class StorePromotionServiceApplication {
    public static void main(String[] args) {
        Store store = new Store();

        Listener subUnSubListener = new EmailMessageListener("pqr@gmail.com");
        store.getNotificationService().subscribe(EventType.NEW_ITEM,new EmailMessageListener("abcd@gmail.com"));
        store.getNotificationService().subscribe(EventType.SALE,new EmailMessageListener("abcd@gmail.com"));
        store.getNotificationService().subscribe(EventType.NEW_ITEM,new EmailMessageListener("xyz@gmail.com"));
        store.getNotificationService().subscribe(EventType.NEW_ITEM,subUnSubListener);
        store.getNotificationService().subscribe(EventType.SALE,new EmailMessageListener("pqr@gmail.com"));

        store.addNewItem();
        System.out.println("===============================================================");
        store.addNewSale();
        System.out.println("===============================================================");

        store.getNotificationService().unsubscribe(EventType.NEW_ITEM,subUnSubListener);
        store.addNewItem();
    }
}
