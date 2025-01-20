package com.example.neobank.repositories;

import com.example.neobank.models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionsRepository extends JpaRepository<Transactions, UUID> {
}
