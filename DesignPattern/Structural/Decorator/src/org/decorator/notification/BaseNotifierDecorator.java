package org.decorator.notification;

// This is decorator Base class which gets used by Facebook and Whatsapp Decorator
public  abstract class BaseNotifierDecorator implements INotifier{

    private final INotifier wrapped;
    protected final DBService dbService;

    BaseNotifierDecorator(INotifier wapped){
        this.wrapped  = wapped;
        this.dbService = new DBService();
    }

    @Override
    public void send(String message){
        wrapped.send(message);
    }

    @Override
    public String getUserName(){
        return wrapped.getUserName();
    }
}
