import org.state.Phone;
// https://www.youtube.com/watch?v=abX4xzaAsoc&t=199s
//https://github.com/geekific-official/geekific-youtube/blob/main/pattern-behavioral-state/src/main/java/com/youtube/geekific/Phone.java
public class StateApp {
    public static void main(String[] args) {
        Phone phone = new Phone();

        phone.clickPower();// Off State
        phone.clickHome();// locked state
        phone.clickHome(); // ready state
        phone.clickHome();// ready state
        phone.clickPower();// off state
        phone.clickPower();// locked state
    }
}