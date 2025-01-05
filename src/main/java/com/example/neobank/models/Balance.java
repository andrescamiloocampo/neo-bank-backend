package com.example.neobank.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.FetchMode;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "balance")
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "account_number",nullable = false,unique = true)
    private String account_number;

    @Column(name = "total_amount", nullable = false)
    private long totalAmount;

    @Column(name = "account_type", nullable = false)
    private String accountType;

    @JsonManagedReference
    @OneToMany(mappedBy = "balance", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pocket> pockets;

    @JsonBackReference
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    public Balance(UUID id, long totalAmount, List<Pocket> pockets, User user, String accountType, String account_number) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.pockets = pockets;
        this.user = user;
        this.accountType = accountType;
        this.account_number = account_number;
    }

    public Balance() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Pocket> getPockets() {
        return pockets;
    }

    public void setPockets(List<Pocket> pockets) {
        this.pockets = pockets;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public void subtractAmount(long amount){
        this.totalAmount -= amount;
    }

    public void addAmount(long amount){
        this.totalAmount += amount;
    }
}
