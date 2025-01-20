package com.example.neobank.services;

import com.example.neobank.models.Balance;
import com.example.neobank.models.Pocket;
import com.example.neobank.models.User;
import com.example.neobank.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Transactional
    public User getUser(String username){
        return userRepository.findByUsernameWithBalance(username);
    }

    public Balance getUserAccount(String username, String account_type){
        return userRepository.findByUsernameWithBalance(username)
                .getBalance()
                .stream()
                .filter(balance -> balance.getAccountType().equals(account_type))
                .findFirst()
                .orElse(null);

    }

    public Balance getUserAccountById(UUID user_id, String account_type){
        return userRepository.findByByIdWithBalance(user_id)
                .getBalance()
                .stream()
                .filter(balance -> balance.getAccountType().equals(account_type))
                .findFirst()
                .orElse(null);

    }
    
    public User[] getUsersByUsername(String username){
        return userRepository.findUsersByUsername(username);
    }

}
