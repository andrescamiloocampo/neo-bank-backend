package com.example.neobank.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "transaction_type",length = 255, nullable = false)
    private String transaction_type;

    @Column(name = "account_type",nullable = false)
    private String account_type;

    @Column(name = "amount", nullable = false)
    private long amount;

    @Column(name = "timestamp", nullable = false)
    private Date timestamp;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "from_account",nullable = false)
    private String fromAccount;

    @Column(name = "from_pocket", nullable = true)
    private String fromPocket;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "id",insertable = false,updatable = false)
    @JsonBackReference
    private User user;

    @Column(name = "user_id",nullable = false)
    private UUID userId;

    public  Transactions() {
    }

    public Transactions(UUID id, String transaction_type,String account_type, long amount, Date timestamp, String description, UUID userId,String fromAccount,String fromPocket) {
        this.id = id;
        this.account_type = account_type;
        this.transaction_type = transaction_type;
        this.amount = amount;
        this.timestamp = timestamp;
        this.description = description;
        this.fromAccount = fromAccount;
        this.fromPocket = fromPocket;
        this.userId = userId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
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

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getFromPocket() {
        return fromPocket;
    }

    public void setFromPocket(String fromPocket) {
        this.fromPocket = fromPocket;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
