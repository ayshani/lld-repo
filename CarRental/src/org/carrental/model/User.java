package org.carrental.model;

import lombok.Getter;
import org.carrental.util.AccountStatus;

import java.util.Date;

@Getter
public class User extends Account{
    private String drivingLicenseNumber;
    private Date licenseExpiry;

    public User(String name, String address, String email, int phoneNumber, String password, String drivingLicense,
                Date licenseExpiry) {
        super(name, address, email, phoneNumber, password, AccountStatus.ACTIVE);
        this.drivingLicenseNumber = drivingLicense;
        this.licenseExpiry = licenseExpiry;
    }


    @Override
    public boolean resetPassword(String pass) {
        this.setPassword(pass);
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "drivingLicenseNumber='" + drivingLicenseNumber + '\'' +
                ", licenseExpiry=" + licenseExpiry +
                ", accountStatus=" + accountStatus +
                "} " + super.toString();
    }
}
