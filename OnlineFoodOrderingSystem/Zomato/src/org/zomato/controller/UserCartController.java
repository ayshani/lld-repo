package org.zomato.controller;

import org.zomato.model.Cart;
import org.zomato.model.Item;
import org.zomato.model.User;

public class UserCartController {

    private RestaurantController restaurantController;

    public UserCartController(RestaurantController restaurantController){
        this.restaurantController = restaurantController;
    }

    public void addItemToCart(User user, Item item){
        Cart userCart = user.getUserCart();
        if(userCart.getRestaurant()== null){
            userCart.setRestaurant(restaurantController.findRestaurantById(item.getRestaurantId()));
        }
        if(!userCart.getRestaurant().getRestaurantId().equals(item.getRestaurantId())){
            System.out.println("Resetting " + user.getUserName() +"'s cart");
            userCart.resetCart();
            userCart.setRestaurant(restaurantController.findRestaurantById(item.getRestaurantId()));
        }
        userCart.addToCart(item);
        System.out.println( user.getUserName() +" added item : "+  item.getItemName() +" of price : "+ item.getPrice());
    }

    public void removeItemFromCart(User user, Item item){
        user.getUserCart().addToCart(item);
    }

    public int getCartPrice(User user){
        return user.getUserCart().getCartPrice();
    }
}
