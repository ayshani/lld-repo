package org.carrental.model;

import org.carrental.util.AccountStatus;

public abstract class Account extends Person{
    private String countId;
    private String password;
    AccountStatus accountStatus;

    public abstract boolean resetPassword(String pass);

}
