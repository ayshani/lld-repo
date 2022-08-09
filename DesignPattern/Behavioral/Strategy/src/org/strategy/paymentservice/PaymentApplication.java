package org.strategy.paymentservice;

import java.util.Date;

// https://www.digitalocean.com/community/tutorials/strategy-design-pattern-in-java-example-tutorial
public class PaymentApplication {
    public static void main(String[] args) {
        Item itemA = new Item("A",100);
        Item itemB = new Item("B", 200);


        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addItem(itemA);
        shoppingCart.addItem(itemB);

        // Paypal Payment Strategy
        PaymentStrategy paymentStrategy = new PayPalStrategy("PaypalAccount","abcd");
        PaymentService paymentService = new PaymentService(paymentStrategy);

        shoppingCart.setPaymentService(paymentService);

        shoppingCart.pay();

        Item itemC = new Item("C", 300);

        shoppingCart.addItem(itemC);
        // Credit card Payment Startegy
        paymentStrategy = new CreditCardStrategy("Hastings",123456789L,234,new Date());
        paymentService.setPaymentStrategy(paymentStrategy);
        shoppingCart.pay();

    }

    /*
    output
    ---------
    Paypal Account is validated
    Amount 300 paid using Paypal
    Credit Card is validated
    Amount 600 paid using Credit Card
     */
}
