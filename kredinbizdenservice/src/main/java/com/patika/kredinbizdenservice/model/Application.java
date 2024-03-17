package com.patika.kredinbizdenservice.model;


import com.patika.kredinbizdenservice.enums.ApplicationStatus;

import java.time.LocalDateTime;

public class Application {

    private BankProduct bankProduct;//CreditCard or Loan, Customers will apply for Loan or CreditCard
    private User user;
    private LocalDateTime localDateTime;
    private ApplicationStatus applicationStatus;

    private Application() {

    }


    public Application(BankProduct bankProduct, User user, LocalDateTime localDateTime, ApplicationStatus applicationStatus) {
        this.bankProduct = bankProduct;
        this.user = user;
        this.localDateTime = localDateTime;
        this.applicationStatus = applicationStatus;
    }


    public Application(BankProduct bankProduct, User user, LocalDateTime localDateTime) {
        this.bankProduct = bankProduct;
        this.user = user;
        this.localDateTime = localDateTime;
        this.applicationStatus = ApplicationStatus.INITIAL;
    }

    public Application( User user, LocalDateTime localDateTime) {
        this.user = user;
        this.localDateTime = localDateTime;
        this.applicationStatus = ApplicationStatus.INITIAL;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
    public BankProduct getBankProduct() {
        return bankProduct;
    }

    public void setBankProduct(BankProduct bankProduct) {
        this.bankProduct = bankProduct;
    }
    @Override
    public String toString() {
        return "Application{" +
                "bankProduct=" + bankProduct +
                ", user=" + user +
                ", localDateTime=" + localDateTime +
                ", applicationStatus=" + applicationStatus +
                '}';
    }
}
