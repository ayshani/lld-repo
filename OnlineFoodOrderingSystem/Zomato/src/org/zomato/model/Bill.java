package org.zomato.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Bill {
    private String billId;
    private Cart cart;

    public Bill(Cart cart) {
        billId = UUID.randomUUID().toString();
        this.cart = cart;
    }

    public int getBillPrice(){
        return cart.getCartPrice();
    }
}
