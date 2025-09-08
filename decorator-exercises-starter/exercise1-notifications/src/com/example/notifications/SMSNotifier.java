package com.example.notifications;

public class SMSNotifier extends NotifierDecorator {
    public SMSNotifier(Notifier wrappee) {
        super(wrappee);
    }

    @Override
    public void notify(String text) {
        System.out.println("Sending SMS: " + text);
        super.notify(text);
    }
}
