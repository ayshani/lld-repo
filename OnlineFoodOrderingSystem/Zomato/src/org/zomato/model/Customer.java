package org.zomato.model;

import org.zomato.util.UserType;

public class Customer extends User{
    public Customer(String userName, String email) {
        super(userName, UserType.CUSTOMER, email);
    }
}
