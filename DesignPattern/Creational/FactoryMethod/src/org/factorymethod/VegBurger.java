package org.factorymethod;

public class VegBurger extends Burger{
    @Override
    void prepare() {
        System.out.println("Preparing Veg Burger....");
    }
}
