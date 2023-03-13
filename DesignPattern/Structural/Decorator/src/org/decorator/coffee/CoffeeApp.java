package org.decorator.coffee;


// Head first design pattern
public class CoffeeApp {
    public static void main(String[] args) {
        Beverage beverage = new Whip(new Mocha(new Mocha(new DarkRoast())));
        String description = beverage.getDescription();
        double cost = beverage.cost();
        System.out.println(description +"  and cost : "+ cost);
    }
}
