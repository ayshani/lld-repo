package org.observer.storepromonotification;

// Mobile App observer
public class MobileAppListener implements Listener{

    private String userName;

    public MobileAppListener(String userName){
        this.userName = userName;
    }
    @Override
    public void update(EventType eventType) {
        // Actually send the push notification to username
        System.out.println("Sending mobile app notification to " + userName + " concerning " + eventType);
    }
}
