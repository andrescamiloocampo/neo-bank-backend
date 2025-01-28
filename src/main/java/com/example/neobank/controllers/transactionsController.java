package com.example.neobank.controllers;

import com.example.neobank.dto.PaginationTransactionsDTO;
import com.example.neobank.services.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
@CrossOrigin("*")
public class transactionsController {
    @Autowired
    TransactionsService transactionsService;

    @GetMapping("/getAll")
    private PaginationTransactionsDTO getTransactions(@RequestParam(value = "page", defaultValue = "1", required = false) int page, @RequestParam(value = "registers", defaultValue = "10", required = false) int registers, @RequestParam(value = "user_id") String uid) {
        return transactionsService.getAllTransactions(page, registers,uid);
    }
}
