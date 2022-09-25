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
            // Update balance of the user for whom the amount is paid in Paid-By user balance sheet
            String paidFor = split.getUser().getUserName();

            Map<String,Double> balances = balanceSheet.get(paidBy);
            if(!balances.containsKey(paidFor)) {
                balances.put(paidFor, 0.0);
            }
            balances.put(paidFor, balances.get(paidFor)+ split.getAmount());
            // Update balance of the user who paid the amount in Paid-For user balance sheet
            balances = balanceSheet.get(paidFor);
            if(!balances.containsKey(paidBy)){
                balances.put(paidBy,0.0);
            }

            balances.put(paidBy, balances.get(paidBy) - split.getAmount());
        }
    }

    public List<String> getBalance(String userName){
        List<String> balances = new ArrayList<>();
        for(Map.Entry<String, Double> userBalance : balanceSheet.get(userName).entrySet()){
            if(userBalance.getValue()!= 0){
                balances.add(prepareBalanceMessage(userName, userBalance.getKey(),userBalance.getValue()));
            }
        }
        return balances;
    }

    public List<String> getBalances(){
        List<String> balances = new ArrayList<>();
        for(String user: balanceSheet.keySet()){
            balances.addAll(getBalance(user));
        }
         return balances;
    }
    private String prepareBalanceMessage(String user1Name, String user2Name, Double amount) {
        /*String user1Name = userMap.get(user1).getUserName();
        String user2Name = userMap.get(user2).getUserName();*/

        if(amount<0){
            return user1Name +  " owes "+ user2Name + " : " + Math.abs(amount);
        } else if( amount > 0){
            return user2Name +  " owes "+ user1Name + " : " + Math.abs(amount);
        }

        return "";
    }

}
