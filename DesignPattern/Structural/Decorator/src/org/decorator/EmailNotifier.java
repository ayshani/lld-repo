package org.decorator;

// This is one of the concrete Notifier class
public class EmailNotifier implements INotifier{

    private final String username;
    private final DBService dbService;

    public EmailNotifier(String username){
        this.username=username;
        this.dbService = new DBService();
    }
    @Override
    public void send(String message) {
        String mailBy = dbService.getMailFromUsername(username);
        System.out.println("Sending "+ message +"by Mail to  "+ mailBy);
    }

    @Override
    public String getUserName() {
        return username;
    }
}
