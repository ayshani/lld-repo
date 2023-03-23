package org.carrental.model;

import lombok.Getter;
import org.carrental.util.AccountStatus;

import java.util.Date;

@Getter
public class Driver extends Account{

    private String driverId;
    private String drivingLicenseNumber;
    private Date licenseExpiry;

    public Driver(String name, String address, String email, int phoneNumber, String password, AccountStatus accountStatus) {
        super(name, address, email, phoneNumber, password, AccountStatus.ACTIVE);
    }


    @Override
    public boolean resetPassword(String pass) {
        this.setPassword(pass);
        return true;
    }
}
