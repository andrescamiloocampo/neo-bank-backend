package com.example.neobank.services;

import com.example.neobank.models.Balance;
import com.example.neobank.models.Pocket;
import com.example.neobank.models.Transactions;
import com.example.neobank.repositories.BalanceRepository;
import com.example.neobank.repositories.PocketRepository;
import com.example.neobank.repositories.TransactionsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalanceService {

    @Autowired
    UserService userService;

    @Autowired
    PocketService pocketService;

    @Autowired
    TransactionsRepository transactionsRepository;

    @Autowired
    BalanceRepository balanceRepository;

    @Autowired
    PocketRepository pocketRepository;


    @Transactional
    public Balance transferMoney(String receiverName, Transactions transaction, String senderAccountType) {
        try {
            Balance receiver = userService.getUserAccount(receiverName, "Savings Account");
            Balance sender = userService.getUserAccountById(transaction.getUserId(), senderAccountType);

            if (transaction.getAccount_type().equals("Pocket")) {
                Pocket senderPocket = pocketService.getPocketInBalance(transaction.getFromAccount(), transaction.getFromPocket());
                if (senderPocket != null) {
                    senderPocket.substractAmount(transaction.getAmount());
                    receiver.addAmount(transaction.getAmount());
                    balanceRepository.save(receiver);
                    pocketRepository.save(senderPocket);
                    transactionsRepository.save(transaction);

                    return sender;
                }
                return sender;
            }

            sender.subtractAmount(transaction.getAmount());
            receiver.addAmount(transaction.getAmount());

            transactionsRepository.save(transaction);
            balanceRepository.save(sender);
            balanceRepository.save(receiver);

            return sender;
        } catch (Exception e) {
            throw new RuntimeException("Transaction failed: " + e.getMessage(), e);
        }
    }


}
