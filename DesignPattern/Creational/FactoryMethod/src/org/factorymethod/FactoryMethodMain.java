package org.factorymethod;

//https://github.com/geekific-official/geekific-youtube/blob/main/pattern-creational-factory/src/main/java/com/youtube/geekific/MainApp.java
//https://www.youtube.com/watch?v=EdFq_JIThqM
public class FactoryMethodMain {
    public static void main(String[] args) {

        Restaurant nonVegRestaurant = new ChickenBurgerRestaurant();
        nonVegRestaurant.orderBurger();

        System.out.println("----------------------");

        Restaurant vegRestaurant = new VegBurgerReataurant();
        vegRestaurant.orderBurger();
    }
}