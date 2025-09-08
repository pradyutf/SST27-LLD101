package com.example.notifications;

public class WhatsAppNotifier extends NotifierDecorator {
    public WhatsAppNotifier(Notifier wrappee) {
        super(wrappee);
    }

    @Override
    public void notify(String text) {
        System.out.println("Sending WhatsApp: " + text);
        super.notify(text);
    }
}
