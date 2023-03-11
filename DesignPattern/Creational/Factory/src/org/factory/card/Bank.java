package org.factory.card;

import java.util.Scanner;

//https://medium.com/geekculture/overview-of-factory-method-design-pattern-d3a6fe908ea4
public class Bank {

    public static void main(String[] args) {
        String cardtype="";
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your salary :");
        double salary=sc.nextDouble();

        if(salary<50000){
            cardtype="Silver";
        }else if(salary <100000){
            cardtype="Gold";
        }else{
            cardtype="Platinum";
        }

        Card mycard=Factory.getcard(cardtype);
        System.out.println(mycard);
    }

}
