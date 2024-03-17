package com.patika.kredinbizdenservice.model;



import com.patika.kredinbizdenservice.enums.LoanType;

import java.math.BigDecimal;

public class HouseLoan extends Loan {

    private LoanType loanType = LoanType.KONUT_KREDISI;

    public HouseLoan(Bank bank) {
        super(bank);
    }

    public HouseLoan(Bank bank,BigDecimal amount, Integer installment, Double interestRate) {
        super(bank,amount, installment, interestRate);
    }

    public LoanType getLoanType() {
        return loanType;
    }

    @Override
    void calculate(BigDecimal amount, int installment) {

    }
}
