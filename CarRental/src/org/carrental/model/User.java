package org.carrental.model;

import java.util.Date;

public class User extends Account{
    private String drivingLicenseNumber;
    private Date licenseExpiry;


    @Override
    public boolean resetPassword(String pass) {
        return false;
    }

}
