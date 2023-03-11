package org.factorymethod;

public class ChickenBurger extends Burger{
    @Override
    void prepare() {
        System.out.println("Preparing chicken Burger....");
    }
}
