package com.stackoverflow.model;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;
/*
Bounty:

Properties of Bounty:
Bounty specifies how much reputation a member is going to get if his/her answer satisfies the question asker.
Bounty has an expiration date.
Question Asker can modify the reputation associated with the Bounty.
 */
@Getter
public class Bounty {
    private int reputation;
    private long expirationDate;

    public Bounty(int reputation, long expirationDate) {
        this.reputation = reputation;
        this.expirationDate = expirationDate;
    }

    public void modifyReputation(int reputation){
        this.reputation = reputation;
    }

    @Override
    public String toString() {
        return "Bounty{" +
                "reputation=" + reputation +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
