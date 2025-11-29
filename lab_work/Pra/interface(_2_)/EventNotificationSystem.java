
@FunctionalInterface
interface Notifier {
    void send(String message);

    default void notifyUser(String message) {
        send("[NOTIFICATION] " + message);
        log(message);
    }

    static void log(String msg) {
        System.out.println("Log: " + msg);
    }
}

interface UrgentNotification { }

class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}

class SMSNotifier implements Notifier, UrgentNotification {
    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}

class PushNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Push: " + message);
    }
}

public class EventNotificationSystem {
    public static void main(String[] args) {
     
        Notifier email = new EmailNotifier();
        Notifier sms = new SMSNotifier();
        Notifier push = new PushNotifier();

        email.notifyUser("Welcome to the Event!");
        sms.notifyUser("Your OTP is 12345");
        push.notifyUser("Event starts at 7 PM");

        Notifier lambdaNotifier = msg -> System.out.println("Lambda: " + msg);
        lambdaNotifier.notifyUser("Quick notification via lambda!");

        if (sms instanceof UrgentNotification) {
            System.out.println(" SMS is URGENT!");
        }
        
        System.out.println("24CE092-Prince Patel");
    }
}
