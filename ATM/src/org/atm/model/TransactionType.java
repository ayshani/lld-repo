package org.atm.model;

public enum TransactionType {

    CASH_WITHDRAWAL,
    BALANCE_CHECk;

    public static void showAllTransactionType(){
        for(TransactionType transactionType : TransactionType.values()){
            System.out.println(transactionType.name());
        }
    }
}
