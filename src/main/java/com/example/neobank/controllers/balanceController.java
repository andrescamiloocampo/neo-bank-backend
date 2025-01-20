package com.example.neobank.controllers;

import com.example.neobank.dto.TransactionRequestDTO;
import com.example.neobank.models.Balance;
import com.example.neobank.models.Transactions;
import com.example.neobank.services.BalanceService;
import com.example.neobank.services.PocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/balance")
@CrossOrigin("*")
public class balanceController {
    @Autowired
    BalanceService balanceService;

    @Autowired
    PocketService pocketService;

    @PostMapping("/transferMoney")
    public Balance transferMoney(@RequestBody Transactions transaction, @RequestParam(name = "receiver") String receiver, @RequestParam(name = "sender_account_type") String sender_account_type){
        return balanceService.transferMoney(receiver,transaction,sender_account_type);
    }

}
