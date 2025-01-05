package com.example.neobank.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class otpController {

    @GetMapping()
    public String Hello(){
        return "Hello";
    }

    @GetMapping("/otp")
    public String getOtp(){
        return "Codigo otp";
    }
}
