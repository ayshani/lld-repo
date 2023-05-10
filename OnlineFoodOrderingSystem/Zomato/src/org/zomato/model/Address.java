package org.zomato.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Address {

    private String addressId;
    private String addressDetail;
    private long latitude;
    private long longitude;

    public Address(String addressDetail, long latitude, long longitude){
        this.addressId = UUID.randomUUID().toString();
        this.addressDetail = addressDetail;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
