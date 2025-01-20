package com.example.neobank.services;

import com.example.neobank.repositories.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionsService {
    @Autowired
    TransactionsRepository transactionsRepository;

    public void makeTransaction(){
        
    }
}
