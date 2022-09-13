package com.splitwise.model.expense;

import com.splitwise.model.User;
import com.splitwise.model.split.EqualSplit;
import com.splitwise.model.split.Split;

import java.util.List;

public class EqualExpense extends Expense{


    public EqualExpense(double amount, User expensePaidBy, List<Split> splits, String expenseName) {
        super(amount, expensePaidBy, splits, expenseName);
    }

    @Override
    public boolean validate() {
        for(Split split : getSplits()){
            if(!(split instanceof EqualSplit)) {
                return false;
            }
        }
        return true;
    }
}
