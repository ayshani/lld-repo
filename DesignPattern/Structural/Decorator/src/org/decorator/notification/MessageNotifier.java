package org.decorator.notification;

// This is one of the concrete Notifier class
public class MessageNotifier implements INotifier{

    private final String username;
    private final DBService dbService;

    public MessageNotifier(String username){
        this.username=username;
        this.dbService = new DBService();
    }
    @Override
    public void send(String message) {
        String phoneBy = dbService.getPhoneNumberFromUsername(username);
        System.out.println("Sending "+ message +" by Message to  "+ phoneBy);
    }

    @Override
    public String getUserName() {
        return username;
    }
}
