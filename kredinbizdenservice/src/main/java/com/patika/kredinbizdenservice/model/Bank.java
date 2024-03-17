package com.patika.kredinbizdenservice.model;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private String name;
    private List<Loan> loanList;//Bankadan alınan kredilerin listesi
    private List<CreditCard> creditCards;//Bankaya ait olan kartların listesi. Her karttan bir kullanıcı sorumlu olmalıdır.

    public Bank(String name) {
        this.name = name;
        this.loanList=new ArrayList<Loan>();
        this.creditCards=new ArrayList<CreditCard>();
    }

    public Bank(String name, List<Loan> loanList) {
        this.name = name;
        this.loanList = loanList;
        this.creditCards=new ArrayList<CreditCard>();
    }

    public Bank(String name, List<Loan> loanList, List<CreditCard> creditCards) {
        this.name = name;
        this.loanList = loanList;
        this.creditCards = creditCards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Loan> getLoanList() {
        return loanList;
    }

    public void setLoanList(List<Loan> loanList) {
        this.loanList = loanList;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", loanList=" + loanList +
                '}';
    }

    public void addNewApplication(Application newApplication) {
        BankProduct bankProduct=newApplication.getBankProduct();
        if(bankProduct instanceof Loan){//if it is a Loan
            loanList.add((Loan)bankProduct);//typecast and add to loanlist
        }
        else if(bankProduct instanceof CreditCard){//if it is a CreditCard
            creditCards.add((CreditCard)bankProduct);//typecast and add to CreditCard
        }
        else{
            System.out.println("Bu BankProduct objesi typecast edilemedi: "+bankProduct.toString());
        }
    }
}
