package org.decorator.notification;

public class FacebookDecorator extends BaseNotifierDecorator{
    public FacebookDecorator(INotifier wapped) {
        super(wapped);
    }

    public void send(String message){
        super.send(message);
        String fbName = dbService.getFBNameFromUserName(getUserName());
        System.out.println("Sending "+ message +" on Facebook to "+ fbName);
    }
}
