package org.observer.storepromonotification;

// Email Observer
public class EmailMessageListener implements Listener{

    private String emailId;

    public EmailMessageListener(String email){
        this.emailId = email;
    }
    @Override
    public void update(EventType eventType) {

        // Actually sending mail to email ID
        System.out.println("Sending mail to "+ emailId+" concerning " + eventType);
    }
}
