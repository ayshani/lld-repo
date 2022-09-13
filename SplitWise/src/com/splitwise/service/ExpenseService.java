package com.splitwise.service;

import com.splitwise.model.ExpenseType;
import com.splitwise.model.User;
import com.splitwise.model.expense.EqualExpense;
import com.splitwise.model.expense.ExactExpense;
import com.splitwise.model.expense.Expense;
import com.splitwise.model.expense.PercentExpense;
import com.splitwise.model.split.PercentSplit;
import com.splitwise.model.split.Split;
import lombok.Builder;

import java.util.List;

public class ExpenseService {

    public static Expense createExpense(String expenseName,ExpenseType expenseType, double amount,
                                        User expensePaidBy, List<Split> splits){
        switch (expenseType){
            case EXACT :
                return new ExactExpense(amount,expensePaidBy,splits,expenseName);
            case PERCENT:
                for( Split split : splits){
                    PercentSplit percentSplit = (PercentSplit) split;
                    split.setAmount((amount*percentSplit.getPercent())/100.0);
                }
                return new PercentExpense(amount,expensePaidBy,splits,expenseName);
            case EQUAL:
                int totalSplits = splits.size();
                double splitAmount = (double) (Math.round(amount*100/totalSplits))/100.0;
                for(Split split : splits){
                    split.setAmount(splitAmount);
                }

                return new EqualExpense(amount,expensePaidBy,splits,expenseName);
            default:
                return null;
        }
    }
}
