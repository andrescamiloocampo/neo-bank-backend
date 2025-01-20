package com.example.neobank.dto;

import java.util.Date;
import java.util.UUID;

public class TransactionRequestDTO {
    private String transactionType;
    private String accountType;
    private long amount;
    private Date timestamp;
    private String description;
    private String fromAccount;
    private String fromPocket;
    private UUID userId;

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFromPocket() {
        return fromPocket;
    }

    public void setFromPocket(String fromPocket) {
        this.fromPocket = fromPocket;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }
}
