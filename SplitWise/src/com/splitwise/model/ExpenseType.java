package com.splitwise.model;

import java.util.HashMap;

public enum ExpenseType {
    EQUAL("EQUAL"),
    EXACT("EXACT"),
    PERCENT("PERCENT");

    private final String expenseName;

    ExpenseType(String expense){
        this.expenseName = expense;
    }

    public String toString(){
        return this.expenseName;
    }

    private static final HashMap<String,ExpenseType> map = new HashMap<>(values().length,1);

    static {
        for(ExpenseType expenseType : values()){
            map.put(expenseType.expenseName , expenseType);
        }
    }

    public static ExpenseType of(String name) {
        return map.get(name);
    }
}
