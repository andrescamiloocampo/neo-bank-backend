package com.example.neobank.services;

import com.example.neobank.models.Balance;
import com.example.neobank.models.Pocket;
import com.example.neobank.repositories.BalanceRepository;
import com.example.neobank.repositories.PocketRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PocketService {
    @Autowired
    private PocketRepository pocketRepository;

    @Autowired
    private BalanceRepository balanceRepository;

    @Transactional
    public Pocket createPocket(Pocket pocket) {
        if (pocket.getBalance() == null) {
            throw new IllegalArgumentException("El balance no puede ser nulo.");
        }

        Optional<Balance> existingBalance = balanceRepository.findById(pocket.getBalance().getId());
        if (existingBalance.isEmpty()) {
            throw new IllegalArgumentException("El balance proporcionado no existe.");
        }

        existingBalance.ifPresent(balance -> balance.subtractAmount(pocket.getSub_amount()));

        pocket.setBalance(existingBalance.get());
        return pocketRepository.save(pocket);
    }

    @Transactional
    public Pocket updatePocket(Pocket pocket){
        Optional<Balance> existingBalance = balanceRepository.findById(pocket.getBalance().getId());
        Optional<Pocket> existingPocket = pocketRepository.findById(pocket.getId());

        if (existingBalance.isEmpty()) {
            throw new IllegalArgumentException("El balance proporcionado no existe.");
        }

        existingPocket.ifPresent(value -> existingBalance.ifPresent(balance -> balance.addAmount(value.getSub_amount())));
        existingBalance.ifPresent(balance -> balance.subtractAmount(pocket.getSub_amount()));
        pocket.setBalance(existingBalance.get());
        
        return pocketRepository.save(pocket);
    }

    public Pocket getPocketById(UUID id){
        return pocketRepository.findById(id).orElseThrow(()->new RuntimeException("Pocket not found"));
    }

    public Pocket getPocketInBalance(String pocket_id, String balance_id){
        return pocketRepository.findPocketBalance(pocket_id,balance_id);
    }

}
