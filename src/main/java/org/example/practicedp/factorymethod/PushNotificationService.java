package org.example.practicedp.factorymethod;

public class PushNotificationService extends NotificationService {
    @Override
    public Notification createNotification() {
        return new PushNotification();
    }
}

