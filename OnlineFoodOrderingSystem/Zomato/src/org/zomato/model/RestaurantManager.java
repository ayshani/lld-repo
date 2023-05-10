package org.zomato.model;

import lombok.Getter;
import lombok.Setter;
import org.zomato.util.UserType;

@Getter
public class RestaurantManager extends User{

    @Setter
    private Restaurant restaurant;
    public RestaurantManager(String userName, String email) {
        super(userName, UserType.RESTAURANT_MANAGER, email);

    }
}
