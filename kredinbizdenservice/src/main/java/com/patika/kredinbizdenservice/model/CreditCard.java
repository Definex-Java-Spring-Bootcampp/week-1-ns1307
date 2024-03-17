package com.patika.kredinbizdenservice.model;

import java.math.BigDecimal;
import java.util.List;

public class CreditCard extends BankProduct{


    private List<Campaign> campaignList;// Bu kredi kartına tanımlanmış olan kampanyaların listesi

    public CreditCard(Bank bank, BigDecimal amount, List<Campaign> campaignList) {
        this.bank=bank;
        this.amount = amount;
        this.campaignList = campaignList;
    }
    public CreditCard(BigDecimal amount, List<Campaign> campaignList) {
        this.amount = amount;
        this.campaignList = campaignList;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public List<Campaign> getCampaignList() {
        return campaignList;
    }

    public void setCampaignList(List<Campaign> campaignList) {
        this.campaignList = campaignList;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "fee=" + amount +
                ", campaignList=" + campaignList +
                ", bank=" + bank +
                '}';
    }
}
