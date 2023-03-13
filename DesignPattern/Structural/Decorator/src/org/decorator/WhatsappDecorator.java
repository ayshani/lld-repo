package org.decorator;

public class WhatsappDecorator extends BaseNotifierDecorator{
    public WhatsappDecorator(INotifier wapped) {
        super(wapped);
    }

    public void send(String message){
        super.send(message);
        String phoneNumber = dbService.getPhoneNumberFromUsername(getUserName());
        System.out.println("Sending "+ message +" on Whatsapp to "+ phoneNumber);
    }
}
