package com.microservice.app.clients.notification;
import com.microservice.app.clients.comman.bean.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("notification")
public interface NotificationClient {
    @PostMapping("api/v1/notification")
    public void setNotificationRequest(@RequestBody NotificationRequest notificationRequest);
}
