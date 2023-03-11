import org.abstractfactory.factories.AsusManufacturer;
import org.abstractfactory.factories.Company;
import org.abstractfactory.factories.MsiManufacturer;
import org.abstractfactory.product.Product;

import java.util.List;

//https://github.com/geekific-official/geekific-youtube/blob/main/pattern-creational-abstract-factory/src/main/java/com/youtube/geekific/MainApp.java
//https://www.youtube.com/watch?v=QNpwWkdFvgQ
public class AbstractFactoryMain {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Company asus = new AsusManufacturer();
        Company msi = new MsiManufacturer();

        List.of(msi.createGpu(), msi.createMonitor(),asus.createGpu(),asus.createMonitor())
                .forEach(Product::assemble);
    }
}