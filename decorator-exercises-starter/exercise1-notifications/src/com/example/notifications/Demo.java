package com.example.notifications;

/**
 * Starter demo that uses only the existing Email notifier.
 * TODOs guide you to add decorators and compose them.
 */
public class Demo {
    public static void main(String[] args) {
        Notifier base = new EmailNotifier("user@example.com");

        // Baseline behavior (already works)
        base.notify("Baseline email only.");

        // === Decorator compositions ===
        System.out.println("--- Email + SMS ---");
        Notifier emailSms = new SMSNotifier(base);
        emailSms.notify("Hello via Email+SMS!");

        System.out.println("--- Email + WhatsApp ---");
        Notifier emailWhatsApp = new WhatsAppNotifier(base);
        emailWhatsApp.notify("Hello via Email+WhatsApp!");

        System.out.println("--- Email + Slack ---");
        Notifier emailSlack = new SlackNotifier(base);
        emailSlack.notify("Hello via Email+Slack!");

        System.out.println("--- Email + WhatsApp + Slack ---");
        Notifier emailWhatsAppSlack = new SlackNotifier(new WhatsAppNotifier(base));
        emailWhatsAppSlack.notify("Hello via Email+WhatsApp+Slack!");
    }
}
