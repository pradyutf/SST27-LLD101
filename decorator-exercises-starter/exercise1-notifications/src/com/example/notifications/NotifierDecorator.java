package com.example.notifications;

public abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappee;

    public NotifierDecorator(Notifier wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void notify(String text) {
        if (wrappee != null) {
            wrappee.notify(text);
        }
    }
}
