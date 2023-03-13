import org.adapter.FancyUIServiceAdapter;
import org.adapter.IMultiRestApp;
import org.adapter.MultiRestoApp;
import org.adapter.XmlData;

//https://github.com/geekific-official/geekific-youtube/blob/main/pattern-structural-adapter/src/main/java/com/youtube/geekific/MainApp.java
//https://www.youtube.com/watch?v=wA3keqCeKtM&list=PLlsmxlJgn1HJpa28yHzkBmUY-Ty71ZUGc&index=18

public class AdapterMain {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        XmlData xmlData =  new XmlData();
        IMultiRestApp multiRestApp = new MultiRestoApp();
        multiRestApp.displayMenu(xmlData);
        multiRestApp.displayRecommendations(xmlData);

        System.out.println("------------------");
        IMultiRestApp adapter = new FancyUIServiceAdapter();
        adapter.displayMenu(xmlData);
        adapter.displayRecommendations(xmlData);

    }
}