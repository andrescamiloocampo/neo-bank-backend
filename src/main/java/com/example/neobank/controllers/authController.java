package com.example.neobank.controllers;

import com.example.neobank.models.User;
import com.example.neobank.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class authController {

    private static class Response{
        private String message;
        private String token;
        private String username;

        Response(String message, String token,String username){
            this.message = message;
            this.token = token;
            this.username = username;
        }

        Response(){}

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    private User createUser(@RequestBody User user){
        return authService.createUser(user);
    }

    @PostMapping("/login")
    private ResponseEntity<Response> loginUser(@RequestBody User user){
        try {
            String token = authService.loginUser(user);
            return ResponseEntity.ok(new Response("Ok", token,user.getUsername()));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new Response(null, "Invalid credentials: " + e.getMessage(),null));
        }
    }

}
