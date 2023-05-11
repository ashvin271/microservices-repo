package com.microservice.app.clients.comman.bean;

import lombok.*;

import java.util.Date;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationRequest {
    private Long id;
    private Long toCustomerId;
    private String customerEmail;
    private String sender;
    private String message;
    private Date dateTime;

    public NotificationRequest(Long toCustomerId, String customerEmail, String message,String sender) {
        this.toCustomerId = toCustomerId;
        this.customerEmail = customerEmail;
        this.message = message;
        this.sender= sender;
    }
}