import org.decorator.*;

//https://github.com/geekific-official/geekific-youtube/blob/main/pattern-structural-decorator/src/main/java/com/youtube/geekific/MainApp.java
//https://www.youtube.com/watch?v=v6tpISNjHf8&list=PLlsmxlJgn1HJpa28yHzkBmUY-Ty71ZUGc&index=20
public class DecoratorMain {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        INotifier notifyFBWhatsappEmail = new FacebookDecorator(new WhatsappDecorator( new EmailNotifier("Geek")));
        notifyFBWhatsappEmail.send("Like and subscribe.....");

        System.out.println("==========================================");

        INotifier notifyByMessage = new FacebookDecorator(new MessageNotifier("Old Geek"));
        notifyByMessage.send("Follow for more");

        System.out.println("==========================================");

        INotifier notifyByWhatsappMessage = new WhatsappDecorator(new MessageNotifier("Ayshani"));
        notifyByWhatsappMessage.send("Here it goes");

    }
}