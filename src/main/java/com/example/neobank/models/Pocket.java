package com.example.neobank.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="pockets")
public class Pocket {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name = "sub_amount",nullable = false)
    private long sub_amount;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "balance_id", nullable = false)
    private Balance balance;

    public Pocket() {
    }

    public Pocket(UUID id, String name, long sub_amount, Balance balance) {
        this.id = id;
        this.name = name;
        this.sub_amount = sub_amount;
        this.balance = balance;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSub_amount() {
        return sub_amount;
    }

    public void setSub_amount(long sub_amount) {
        this.sub_amount = sub_amount;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public void substractAmount(long amount){
        this.sub_amount -= amount;
    }

    public void addAmount(long amount){
        this.sub_amount += amount;
    }
}
