package com.example.neobank.dto;

import com.example.neobank.models.Balance;
import com.example.neobank.models.User;

import java.util.List;
import java.util.UUID;

public class UserDTO {
    private UUID id;
    private String email;
    private String username;
    private String name;
    private String lastname;
    private List<Balance> balance;

    public UserDTO(UUID id, String email, String username, String name, String lastname, List<Balance> balance) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.name = name;
        this.lastname = lastname;
        this.balance = balance;
    }

    public static UserDTO fromUser(User user) {
        return new UserDTO(
                user.getId(),
                user.getEmail(),
                user.getUsername(),
                user.getName(),
                user.getLastname(),
                user.getBalance()
        );
    }

    public UUID getId() { return id; }
    public String getEmail() { return email; }
    public String getUsername() { return username; }
    public String getName() { return name; }
    public String getLastname() { return lastname; }
    public List<Balance> getBalance() { return balance; }
}
