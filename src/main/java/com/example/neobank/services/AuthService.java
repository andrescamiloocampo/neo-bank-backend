package com.example.neobank.services;

import com.example.neobank.models.Balance;
import com.example.neobank.models.User;
import com.example.neobank.repositories.UserRepository;
import com.example.neobank.util.JwtUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Balance balance = new Balance();
        balance.setUser(user);
        balance.setTotalAmount(0);
        balance.setAccountType("Cuenta de Ahorros");
        balance.setAccount_number(generateRandomAccountNumber());

        user.addBalance(balance);

        return userRepository.save(user);
    }

    @Transactional
    public String loginUser(User user){
        User dbUser = userRepository.findByUsername(user.getUsername())
                .orElseThrow(()->new RuntimeException("User not found"));

        boolean match = passwordEncoder.matches(user.getPassword(),dbUser.getPassword());
        if(match)
            return JwtUtil.generateToken(dbUser.getUsername());
        return "";
    }

    private String generateRandomAccountNumber() {
        Random random = new Random();
        long accountNumber = 1_000_000_000L + (long)(random.nextDouble() * 9_000_000_000L); // Rango: 1000000000 - 9999999999
        return String.valueOf(accountNumber);
    }
}
