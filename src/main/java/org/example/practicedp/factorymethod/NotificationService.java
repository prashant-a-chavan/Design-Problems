package org.example.practicedp.factorymethod;

public abstract class NotificationService {

    public abstract Notification createNotification();

    public void sendNotification() {
        Notification notification = createNotification();

        notification.notifyUser();
    }
}
