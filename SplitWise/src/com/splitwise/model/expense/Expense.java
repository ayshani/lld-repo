package com.splitwise.model.expense;

import com.splitwise.model.User;
import com.splitwise.model.split.Split;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public abstract class Expense {
    private final String id;
    private double amount;
    private User expensePaidBy;
    private List<Split> splits;
    private String expenseName;

    public Expense(double amount, User expensePaidBy, List<Split> splits, String expenseName) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.expensePaidBy = expensePaidBy;
        this.splits = splits;
        this.expenseName = expenseName;
    }

    public abstract boolean validate();
}
