package com.splitwise.model.expense;

import com.splitwise.model.User;
import com.splitwise.model.split.ExactSplit;
import com.splitwise.model.split.Split;

import java.util.List;

public class ExactExpense extends Expense{
    public ExactExpense(double amount, User expensePaidBy, List<Split> splits, String expenseName) {
        super(amount, expensePaidBy, splits, expenseName);
    }

    @Override
    public boolean validate() {
        double totalAmount = getAmount();
        double totalSplitAmount =0;
        for(Split split : getSplits()){
            if(!(split instanceof ExactSplit))
            {
                return false;
            }
            //ExactSplit exactSplit = (ExactSplit) split;
            totalSplitAmount+=split.getAmount();
        }

        return totalSplitAmount==totalAmount;
    }
}
