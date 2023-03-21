package org.carrental.model;

import java.util.Date;

public class Driver extends Account{

    private String driverId;
    private String drivingLicenseNumber;
    private Date licenseExpiry;

    @Override
    public boolean resetPassword(String pass) {
        return false;
    }
}
