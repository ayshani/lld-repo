package com.splitwise.model.expense;

import com.splitwise.model.User;
import com.splitwise.model.split.PercentSplit;
import com.splitwise.model.split.Split;

import java.util.List;

public class PercentExpense extends Expense{
    public PercentExpense(double amount, User expensePaidBy, List<Split> splits, String expenseName) {
        super(amount, expensePaidBy, splits, expenseName);
    }

    @Override
    public boolean validate() {
        double totalSplitPercentage =0.0;
        for(Split split : getSplits()){
            if(!(split instanceof PercentSplit)){
                return false;
            }
            totalSplitPercentage+=((PercentSplit) split).getPercent();
        }

        return 100.0==totalSplitPercentage;
    }
}
