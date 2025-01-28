package com.example.neobank.services;

import com.example.neobank.dto.PaginationStatsDTO;
import com.example.neobank.dto.PaginationTransactionsDTO;
import com.example.neobank.models.Transactions;
import com.example.neobank.repositories.TransactionsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionsService {
    @Autowired
    TransactionsRepository transactionsRepository;

    @Transactional
    public PaginationTransactionsDTO getAllTransactions(int page, int registers, String user_id){
        try{
            PaginationTransactionsDTO response = new PaginationTransactionsDTO();
            List<Transactions> transactions = transactionsRepository.getTransactions((page-1)*registers,registers,user_id);
            PaginationStatsDTO pagination = transactionsRepository.getPaginationInfo(registers,user_id);

            response.setPaginationStats(pagination);
            response.setTransactions(transactions);

            return response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
