package com.splitwise.service;

import com.splitwise.model.ExpenseType;
import com.splitwise.model.split.Split;
import com.splitwise.repository.Group;

import java.util.List;
import java.util.Set;

public class SplitwiseService {
    Group group;

    public SplitwiseService(Group group){
        this.group = group;
    }

    public void addExpense(String expenseName, ExpenseType expenseType, double amount, String expensePaidBy,
                           List<Split> splits){
        group.addExpense(expenseType,amount,expensePaidBy,splits,expenseName);
    }

    public void showBalance(String userName){
        List<String> balances = group.getBalance(userName);

        if(balances.isEmpty()){
            System.out.println("No balance");
        } else{
            for(String balance : balances){
                System.out.println(balance);
            }
        }
    }

    public void showBalances(){
        Set<String> balances = group.getBalances();
        if(balances.isEmpty()){
            System.out.println("No balance");
        } else{
            for(String balance : balances){
                System.out.println(balance);
            }
        }
    }
}
