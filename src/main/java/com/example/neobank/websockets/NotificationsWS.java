package com.example.neobank.websockets;

import com.example.neobank.models.Notification;
import com.example.neobank.models.NotificationStatus;
import com.example.neobank.models.TransactionNotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class NotificationsWS {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/notification")
    @SendTo("/topic/notification")
    public Notification notification(String concept) throws Exception{
        System.out.println("Notification:"+concept);
        return new Notification(concept,"Money transfered",NotificationStatus.CONFIRMATION,new Date());
    }

    @MessageMapping("/transaction-notification")
    public void sendTransactionNotification(TransactionNotificationRequest request){

        Notification senderNotification = new Notification(
                "Transaction Sent",
                String.format("You sent $%s to %s",request.getAmount(),request.getReceiverUsername()),
                NotificationStatus.CONFIRMATION,
                new Date()
        );

        Notification receiverNotification = new Notification(
                "Transaction received",
                String.format("You received $%s from %s",request.getAmount(),request.getSenderUsername()),
                NotificationStatus.CONFIRMATION,
                new Date()
        );

        messagingTemplate.convertAndSendToUser(
                request.getSenderUsername(),
                "/queue/notifications",
                senderNotification
        );

        messagingTemplate.convertAndSendToUser(
                request.getReceiverUsername(),
                "/queue/notifications",
                receiverNotification
        );

    }
    
}
