package com.microservice.notification.service;

import com.microservice.app.clients.comman.bean.NotificationRequest;

public interface NotificationService {
    public void setNotificationRequest(NotificationRequest notificationRequest);
}
