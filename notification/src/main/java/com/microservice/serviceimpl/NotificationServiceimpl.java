package com.microservice.serviceimpl;
import com.microservice.app.clients.comman.bean.NotificationRequest;
import com.microservice.notification.model.Notification;
import com.microservice.notification.repository.NotificationRepository;
import com.microservice.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class NotificationServiceimpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Override
    public void setNotificationRequest(NotificationRequest notificationRequest) {
        notificationRepository.save(Notification.builder()
                .toCustomerId(notificationRequest.getToCustomerId())
                .customerEmail(notificationRequest.getCustomerEmail())
                .message(notificationRequest.getMessage())
                .sender(notificationRequest.getSender())
                .dateTime(new Date())
        .build()
    );
    }
}
