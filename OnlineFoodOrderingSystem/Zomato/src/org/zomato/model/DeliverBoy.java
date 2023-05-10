package org.zomato.model;

import lombok.Getter;
import org.zomato.util.UserType;

@Getter
public class DeliverBoy extends User{

    private long latitude;
    private long longitude;

    public DeliverBoy(String userName, String email) {
        super(userName, UserType.DELIVERY_BOY, email);
        this.latitude = 0;
        this.longitude =0;
    }

    public void updateLocation(long latitude, long longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
