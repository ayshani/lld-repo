package org.decorator.coffee;
//This is Concrete Component
public class DarkRoast  extends Beverage{

    public DarkRoast() {
        description = "Dark Roast Coffee";
    }

    public double cost() {
        return .99;
    }
}
