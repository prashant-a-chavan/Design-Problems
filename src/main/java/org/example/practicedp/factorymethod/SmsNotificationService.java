package org.example.practicedp.factorymethod;

public class SmsNotificationService extends NotificationService {
    @Override
    public Notification createNotification() {
        return new SmsNotification();
    }
}
