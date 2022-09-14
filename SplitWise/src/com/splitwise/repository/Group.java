package com.splitwise.repository;

import com.splitwise.model.ExpenseType;
import com.splitwise.model.User;
import com.splitwise.model.expense.Expense;
import com.splitwise.model.split.Split;
import com.splitwise.service.ExpenseService;

import java.util.*;

public class Group {
    private List<Expense> expenses;
    private Map<String, User> userMap;
    private Map<String,Map<String,Double>> balanceSheet;

    public Group(){
        this.expenses = new ArrayList<>();
        this.userMap = new HashMap<>();
        this.balanceSheet = new HashMap<>();
    }

    public void addUser(User user){
        this.userMap.put(user.getUserName(),user);
        balanceSheet.put(user.getUserName(),new HashMap<>());
    }

    public User getUser(String userName){
        return userMap.get(userName);
    }

    public void addExpense(ExpenseType expenseType, double amount, String paidBy,
                           List<Split> splits, String expenseName) {
        Expense expense = ExpenseService.createExpense(expenseName,expenseType,amount,userMap.get(paidBy),splits);
        expenses.add(expense);
        assert expense !=null;
        for(Split split : expense.getSplits()){
            String paidFor = split.getUser().getUserName();

            Map<String,Double> balances = balanceSheet.get(paidBy);
            if(!balances.containsKey(paidFor)) {
                balances.put(paidFor, 0.0);
            }
            balances.put(paidFor, balances.get(paidFor)+ split.getAmount());
            balances = balanceSheet.get(paidFor);
            if(!balances.containsKey(paidBy)){
                balances.put(paidFor,0.0);
            }

            balances.put(paidBy, balances.get(paidBy) - split.getAmount());
        }
    }


}
