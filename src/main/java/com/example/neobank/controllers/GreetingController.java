package com.example.neobank.controllers;

import com.example.neobank.models.Greeting;
import com.example.neobank.models.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception{
        System.out.println("Connection");
        return new Greeting("Hello "+ HtmlUtils.htmlEscape(message.getName()));
    }
}
