package com.example.neobank.controllers;

import com.example.neobank.dto.UserDTO;
import com.example.neobank.models.Balance;
import com.example.neobank.models.User;
import com.example.neobank.repositories.UserRepository;
import com.example.neobank.services.UserService;
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

    @GetMapping("/getUserAccount")
    public Balance getUserAccount(@RequestParam(name = "username") String username, @RequestParam(name = "type") String account_type){
        return userService.getUserAccount(username,account_type);
    }

    @GetMapping("/getUsersByUsername")
    public User[] getUsersByUsername(@RequestParam(name = "username") String username){
        return userService.getUsersByUsername(username);
    }

    @PutMapping("/updateUserImage")
    public void updateUserImage(@RequestParam(name = "userImage") String userImage, @RequestParam(name = "username") String username){
        userService.updateUserImage(userImage,username);
    }
}
