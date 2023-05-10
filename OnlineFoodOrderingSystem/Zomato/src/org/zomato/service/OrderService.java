package org.zomato.service;

import org.zomato.model.DeliverBoy;
import org.zomato.model.Order;
import org.zomato.model.Payment;
import org.zomato.model.User;
import org.zomato.util.PaymentStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {

    private Map<String, Order> orders;
    private Map<User, List<Order>> userToOrders;

    public OrderService(){
        this.orders = new HashMap<>();
        this.userToOrders = new HashMap<>();
    }

    public Order generateOrder(User user,Payment payment){
        Order order = null;
        if(payment.getPaymentStatus().equals(PaymentStatus.SUCCESSFUL)){
            order = new Order(payment.getBill().getCart().getRestaurant(), payment.getBill().getBillPrice(),user);
            orders.put(order.getOrderId(),order);
            userToOrders.computeIfAbsent(user, value -> new ArrayList<>()).add(order);
        } else{
            System.out.println("Payment not yet successful");
        }

        return order;
    }

    public void addDeliveryBoy(Order order, DeliverBoy deliverBoy){
        order.addDeliveryBoy(deliverBoy);
    }
}
