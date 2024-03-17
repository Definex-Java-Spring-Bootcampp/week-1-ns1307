package com.patika.kredinbizdenservice.model;

import java.math.BigDecimal;

public abstract class  BankProduct {


    //Bankanın ürününü temsil eden abstract class.
    //Bu ürün Kredi veya Kredi Kartı olabilir.
    Bank bank;//Her ürün bir bankaya bağlıdır
    BigDecimal amount;//It is the credit card limit For Credit Card and the Loan amount for Loan.
    //Kredi Kartı için kredi kartı limiti, Kredi için kredi miktarıdır.


    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Bank getBank() {
        return bank;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
