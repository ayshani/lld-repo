package org.factory.burger;

public class SimplefactoryApp {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Burger chickenBurger =  BurgerFactory.createBurger("Chicken");
        Burger vegBurger = BurgerFactory.createBurger("Veg");

    }
}