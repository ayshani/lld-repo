package org.carrental.model;

import lombok.Getter;
import lombok.Setter;
import org.carrental.util.AccountStatus;

import java.util.UUID;


@Getter
@Setter
public abstract class Account extends Person{
    private String accountId;
    private String password;
    AccountStatus accountStatus;

    public Account(String name, String address, String email, int phoneNumber, String password, AccountStatus accountStatus) {
        super(name, address, email, phoneNumber);
        this.accountId = UUID.randomUUID().toString();
        this.password = password;
        this.accountStatus = accountStatus;
    }


    public abstract boolean resetPassword(String pass);

}
