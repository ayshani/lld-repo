package org.atm.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    Card card;
    BankAccount userBankAccount;

}
