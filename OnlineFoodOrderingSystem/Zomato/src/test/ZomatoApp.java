package test;

import org.zomato.Zomato;
import org.zomato.model.*;
import org.zomato.util.RestaurantStatus;

import java.time.LocalTime;
import java.util.List;

public class ZomatoApp {
    public static void main(String[] args) {

        System.out.println("Welcome To Zomato!");

        Zomato app = new Zomato();


        RestaurantManager mg1 = app.addRestaurantManager("Manager1","manager1@gmail.com");
        RestaurantManager mg2 = app.addRestaurantManager("Manager2","manager2@gmail.com");
        RestaurantManager mg3 = app.addRestaurantManager("Manager3","manager3@gmail.com");
        RestaurantManager mg4 = app.addRestaurantManager("Manager4","manager4@gmail.com");

        app.registerRestaurant("Restaurant1",324564214,34546363, LocalTime.of(10,0), LocalTime.of(18,0),mg1);
        app.registerRestaurant("Restaurant2",466887967,79899097, LocalTime.of(10,0), LocalTime.of(20,0),mg2);
        app.registerRestaurant("Restaurant3",243646467,34455454, LocalTime.of(10,0), LocalTime.of(22,0),mg3);
        app.registerRestaurant("Restaurant4",324564215,34546369, LocalTime.of(10,0), LocalTime.of(18,0),mg4);

        app.addItem(mg1, "Item1", 200, 20);
        app.addItem(mg1, "Item2", 100, 10);
        app.addItem(mg1, "Item3", 250, 35);
        app.addItem(mg1, "Item4", 300, 40);
        app.updateRestaurantStatus(mg1, RestaurantStatus.OPEN);

        app.addItem(mg2, "Item1", 200, 20);
        app.addItem(mg2, "Item2", 100, 10);
        app.addItem(mg2, "Item3", 250, 35);
        app.updateRestaurantStatus(mg2, RestaurantStatus.OPEN);

        app.addItem(mg4, "Item1", 250, 20);
        app.addItem(mg4, "Item2", 50, 15);
        app.addItem(mg4, "Item3", 300, 40);
        app.updateRestaurantStatus(mg4, RestaurantStatus.OPEN);

        DeliverBoy db1 = app.addDeliveryBoy("DB1", "db1@gmail.com");
        app.updateDeliveryBoyLocation(db1.getUserId(),324564214+4, 34546363-2);
        DeliverBoy db2 = app.addDeliveryBoy("DB2", "db2@gmail.com");
        app.updateDeliveryBoyLocation(db2.getUserId(),466887967+3, 79899097-1);
        DeliverBoy db3 = app.addDeliveryBoy("DB3", "db3@gmail.com");
        app.updateDeliveryBoyLocation(db3.getUserId(),324564214+4, 34546363-2);
        DeliverBoy db4 = app.addDeliveryBoy("DB4", "db4@gmail.com");
        app.updateDeliveryBoyLocation(db4.getUserId(),324564214+4, 34546363-2);

        Customer customer1 = app.addCustomer("Customer1", "dcus1@gmail.com");
        Customer customer2  = app.addCustomer("Customer2", "dcus2@gmail.com");
        Customer customer3 = app.addCustomer("Customer3", "dcus3@gmail.com");
        Customer customer4  = app.addCustomer("Customer4", "dcus4@gmail.com");

        app.addAddress(customer1, "customer1 address - 1", 3445345, 234254);
        app.addAddress(customer1, "customer1 address - 2", 3564743, 242336);

        app.addAddress(customer2, "customer2 address - 1", 89798, 32234);

        app.addAddress(customer3, "customer3 address - 1", 809, 34234);

        System.out.println("---------CUSTOMER 1--------");
        List<Restaurant> restaurants = app.searchRestaurantByDish(customer1.getUserId(), "Item1");
        restaurants.forEach(System.out::println);
        List<Item> items = app.showItems(customer1.getUserId(), restaurants.get(0));
        items.forEach(System.out::println);

        app.addToCart(customer1.getUserId(), items.get(0));

        items = app.showItems(customer1.getUserId(), restaurants.get(1));
        items.forEach(System.out::println);
        app.addToCart(customer1.getUserId(), items.get(0));
        app.addToCart(customer1.getUserId(), items.get(1));

        System.out.println("---------CUSTOMER 2--------");
        app.updateDeliveryBoyLocation(db3.getUserId(),243646467+3, 34546369+2);
        restaurants = app.searchRestaurantByName(customer2.getUserId(), "Restaurant4");
        restaurants.forEach(System.out::println);
        items = app.showItems(customer2.getUserId(), restaurants.get(0));
        items.forEach(System.out::println);
        app.addToCart(customer2.getUserId(), items.get(0));
        app.addToCart(customer2.getUserId(), items.get(1));

        Order OrderCustomer1  = app.placeOrder(customer1.getUserId());
        Order OrderCustomer2 = app.placeOrder(customer2.getUserId());

        app.checkOrderStatus(customer1.getUserId(), OrderCustomer1);
        app.checkOrderStatus(customer2.getUserId(), OrderCustomer2);


    }
}