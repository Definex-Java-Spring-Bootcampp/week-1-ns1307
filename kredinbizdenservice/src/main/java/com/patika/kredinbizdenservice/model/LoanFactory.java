package com.patika.kredinbizdenservice.model;

import com.patika.kredinbizdenservice.enums.LoanType;

import java.math.BigDecimal;

public class LoanFactory {
    public static Loan getLoan(LoanType loanType,Bank bank) {
        switch (loanType) {
            case ARAC_KREDISI:
                return new VehicleLoan(bank);
            case KONUT_KREDISI:
                return new HouseLoan(bank);
            case IHTIYAC_KREDISI:
                return new ConsumerLoan(bank);
            default:
                throw new IllegalArgumentException("This type of loan is not supported");
        }
    }

    public static Loan getLoan(LoanType loanType,Bank bank, BigDecimal amount, Integer installment, Double interestRate) {
        switch (loanType) {
            case ARAC_KREDISI:
                return new VehicleLoan(bank);
            case KONUT_KREDISI:
                return new HouseLoan(bank);
            case IHTIYAC_KREDISI:
                return new ConsumerLoan(bank);
            default:
                throw new IllegalArgumentException("This type of loan is not supported");
        }
    }
}