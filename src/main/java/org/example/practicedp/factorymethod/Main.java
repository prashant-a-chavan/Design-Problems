package org.example.practicedp.factorymethod;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Factory Method Pattern Example ===\n");

        System.out.println("1. Using Email Notification Service:");
        NotificationService emailService = new EmailNotificationService();
        emailService.sendNotification();

        System.out.println("\n2. Using SMS Notification Service:");
        NotificationService smsService = new SmsNotificationService();
        smsService.sendNotification();

        System.out.println("\n3. Using Push Notification Service:");
        NotificationService pushService = new PushNotificationService();
        pushService.sendNotification();

        System.out.println("\n4. Demonstrating flexibility:");
        processNotification(emailService);
        processNotification(smsService);
        processNotification(pushService);
    }

    private static void processNotification(NotificationService service) {
        System.out.print("Processing with " + service.getClass().getSimpleName() + ": ");
        service.sendNotification();
    }
}
