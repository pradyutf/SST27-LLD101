package com.example.notifications;

public class SlackNotifier extends NotifierDecorator {
    public SlackNotifier(Notifier wrappee) {
        super(wrappee);
    }

    @Override
    public void notify(String text) {
        System.out.println("Sending Slack: " + text);
        super.notify(text);
    }
}
