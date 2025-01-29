package com.example.neobank.models;

import java.util.Date;

public class Notification {
    private String name;
    private String message;
    private NotificationStatus status;
    private Date timestamp;

    public Notification(){}

    public Notification(String name, String message, NotificationStatus status, Date timestamp) {
        this.name = name;
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationStatus getStatus() {
        return status;
    }

    public void setStatus(NotificationStatus status) {
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
