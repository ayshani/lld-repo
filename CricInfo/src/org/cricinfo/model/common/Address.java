package org.cricinfo.model.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private String addresslIne1;
    private String addresslIne2;
    private String addresslIne3;
    private String street;
    private String city;
    private String state;
    private String country;
    private String pincode;
}
