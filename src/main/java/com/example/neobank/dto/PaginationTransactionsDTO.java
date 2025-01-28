package com.example.neobank.dto;

import com.example.neobank.models.Transactions;

import java.util.List;

public class PaginationTransactionsDTO {
    private PaginationStatsDTO paginationStats;
    private List<Transactions> transactions;

    public PaginationTransactionsDTO() {
    }

    public PaginationTransactionsDTO(PaginationStatsDTO paginationStats, List<Transactions> transactions) {
        this.paginationStats = paginationStats;
        this.transactions = transactions;
    }

    public PaginationStatsDTO getPaginationStats() {
        return paginationStats;
    }

    public void setPaginationStats(PaginationStatsDTO paginationStats) {
        this.paginationStats = paginationStats;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }
}
