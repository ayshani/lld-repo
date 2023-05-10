package org.zomato.model;

import lombok.Getter;
import lombok.Setter;
import org.zomato.util.OrderStatus;

import java.util.UUID;

@Getter
public class Order {

    private String orderId;
    private Restaurant restaurant;
    private int oderPrice;
    private User customer;
    private DeliverBoy deliveryBoy;
    private int ETA;
    @Setter
    private OrderStatus orderStatus;

    public Order(Restaurant restaurant, int price, User customer){
        this.orderId = UUID.randomUUID().toString();
        this.restaurant =restaurant;
        this.customer = customer;
        this.orderStatus = OrderStatus.PLACED;
    }

    public void addDeliveryBoy(DeliverBoy deliveryBoy){
        this.deliveryBoy =deliveryBoy;
    }
}
