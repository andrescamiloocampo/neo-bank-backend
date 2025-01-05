package com.example.neobank.controllers;

import com.example.neobank.dto.UserDTO;
import com.example.neobank.models.User;
import com.example.neobank.repositories.UserRepository;
import com.example.neobank.services.UserService;
import com.example.neobank.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class userController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping()
    public List<UserDTO> getUsers(){
        return userRepository.findAll().stream().map(UserDTO::fromUser).collect(Collectors.toList());
    }

    @GetMapping("/getUser")
    public User getUser(@RequestParam(name = "username") String username){
        return userService.getUser(username);
    }
}
