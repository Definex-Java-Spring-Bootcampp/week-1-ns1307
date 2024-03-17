package com.patika.kredinbizdenservice.model;

import com.patika.kredinbizdenservice.enums.LoanType;
import com.patika.kredinbizdenservice.enums.VechileStatusType;

import java.math.BigDecimal;

public class VehicleLoan extends Loan {

    private LoanType loanType = LoanType.ARAC_KREDISI;
    private VechileStatusType vechileStatusType;

    public VehicleLoan(Bank bank) {
        super(bank);
    }

    public VehicleLoan(Bank bank,BigDecimal amount, Integer installment, Double interestRate) {
        super(bank,amount, installment, interestRate);
    }

    public LoanType getLoanType() {
        return loanType;
    }

    @Override
    void calculate(BigDecimal amount, int installment) {
        //istediği kadar ödeme yapabilir.
    }
}
