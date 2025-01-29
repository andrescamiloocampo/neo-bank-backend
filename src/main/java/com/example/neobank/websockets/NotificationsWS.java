package com.example.neobank.websockets;

import com.example.neobank.models.Notification;
import com.example.neobank.models.NotificationStatus;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class NotificationsWS {
    @MessageMapping("/notification")
    @SendTo("/topic/notification")
    public Notification notification(String concept) throws Exception{
        System.out.println("Notification:"+concept);
        return new Notification(concept,"Money transfered",NotificationStatus.CONFIRMATION,new Date());
    }
}
