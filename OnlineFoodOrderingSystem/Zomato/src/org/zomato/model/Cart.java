package org.zomato.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Cart {

    private String cartId;
    private User customer;
    @Setter
    private Restaurant restaurant;
    private int cartPrice;
    private Map<String, Item> itemMap;
    private Map<String, Integer> itemCount;

    public Cart(User customer) {
        this.customer = customer;
        this.cartPrice = 0;
        itemMap = new HashMap<>();
        itemCount = new HashMap<>();
    }

    public void addToCart(Item item){
        itemMap.put(item.getItemId(), item);
        itemCount.put(item.getItemId(), itemCount.getOrDefault(item.getItemId(),0)+1);
        cartPrice += item.getPrice();

    }



    public void removeFromCart(Item item){
        if(itemCount.size()==0 || itemCount.get(item.getItemId())==0){
            return;
        }
        itemCount.put(item.getItemId(), itemCount.get(item.getItemId())-1);
        cartPrice -= item.getPrice();
        if(itemCount.get(item.getItemId())==0){
            itemCount.remove(item.getItemId());
            itemMap.remove(item.getItemId());
        }
    }

    public void resetCart() {
        itemMap.clear();
        itemCount.clear();
        cartPrice = 0;
    }
}
