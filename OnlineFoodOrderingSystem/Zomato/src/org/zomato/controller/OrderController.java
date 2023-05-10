package org.zomato.controller;

import org.zomato.model.DeliverBoy;
import org.zomato.model.Order;
import org.zomato.model.Payment;
import org.zomato.model.User;
import org.zomato.service.OrderService;
import org.zomato.util.OrderStatus;

public class OrderController {
    private OrderService orderService;
    private PaymentController paymentController;
    private UserController userController;

    public OrderController(UserController userController, PaymentController paymentController){
        orderService = new OrderService();
        this.paymentController = paymentController;
        this.userController =userController;
    }

    public Order placeOrder(User user){
        DeliverBoy deliverBoy = isDeliveryBoyAvailable(user);
        if(null==deliverBoy){
            System.out.println("Unable to process Order of User : "+ user.getUserName() +" due to lack of delivery boys" );
            return null;
        }
         Payment payment= paymentController.pay(user);
         Order order = orderService.generateOrder(user,payment);
         assignDeliveryBoy(order,deliverBoy);
         order.setOrderStatus(OrderStatus.PREPARING);
         return order;
    }

    public DeliverBoy isDeliveryBoyAvailable(User user){
        DeliverBoy deliverBoy = userController
                .findNearByDeliveryBoy(user.getUserCart().getRestaurant().getLatitude(),
                        user.getUserCart().getRestaurant().getLongitude());
        return deliverBoy;
    }

    public void assignDeliveryBoy(Order order, DeliverBoy deliverBoy){
       System.out.println("Assigning delivery Boy : "+ deliverBoy.getUserName() +" to order of : "+ order.getCustomer().getUserName());
       orderService.addDeliveryBoy(order,deliverBoy);
    }

    public void checkStatus(Order order){

        order.setOrderStatus(OrderStatus.ENROUTE);
        System.out.println("OrderId : "+ order.getOrderId() +" of customer : "+order.getCustomer().getUserName()+ " status : "+ order.getOrderStatus());
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        order.setOrderStatus(OrderStatus.DELIVERED);
        System.out.println("OrderId : "+ order.getOrderId() +" of customer : "+order.getCustomer().getUserName()+ " status : "+ order.getOrderStatus());
    }

}
