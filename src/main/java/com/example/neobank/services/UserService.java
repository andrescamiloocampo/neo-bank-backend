package com.example.neobank.services;

import com.example.neobank.models.User;
import com.example.neobank.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Transactional
    public User getUser(String username){
        return userRepository.findByUsernameWithBalance(username);
    }
}
