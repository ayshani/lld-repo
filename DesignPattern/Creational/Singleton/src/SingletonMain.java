import org.singleton.Singleton;

//https://www.educative.io/courses/software-design-patterns-best-practices/B8nMkqBWONo
//https://github.com/geekific-official/geekific-youtube/tree/main/pattern-creational-singleton/src/main/java/com/youtube/geekific
//https://github.com/geekific-official/geekific-youtube/blob/main/pattern-creational-singleton/src/main/java/com/youtube/geekific/Singleton.java
public class SingletonMain {
    public static void main(String[] args) {

        System.out.println(Singleton.getInstance("geecific").getData());
        Singleton singleton =  Singleton.getInstance("singleton");

        System.out.println(singleton.getData());

    }
}