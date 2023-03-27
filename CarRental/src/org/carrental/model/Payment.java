package org.carrental.model;

import lombok.Getter;

import java.util.Date;

@Getter
public class Payment {
    private int amount;
    private Date payemntTimeStamp;

    public Payment(int amount, Date payemntTimeStamp) {
        this.amount = amount;
        this.payemntTimeStamp = payemntTimeStamp;
    }
}
