package org.zomato.service;

import org.zomato.model.Bill;
import org.zomato.model.Cart;

import java.util.HashMap;
import java.util.Map;

public class BillService {

     private Map<String,Bill> bills;

     public BillService(){
         bills = new HashMap<>();
     }

     public Bill generateCurrentBill(Cart cart){
         Bill bill = new Bill(cart);
         bills.put(bill.getBillId(),bill);
         return bill;
     }

     public Bill getBill(String billId){
         return bills.get(billId);
     }

     public int getBillPrice(Bill bill){
         return bill.getBillPrice();
     }
}
