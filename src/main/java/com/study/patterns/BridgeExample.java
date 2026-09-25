package com.study.patterns;

import java.util.Objects;

public final class BridgeExample {
    private BridgeExample() {
    }

    public interface MessageSender {
        String send(String message);
    }

    public record EmailSender() implements MessageSender {
        @Override
        public String send(String message) {
            return "email:" + message;
        }
    }

    public record SmsSender() implements MessageSender {
        @Override
        public String send(String message) {
            return "sms:" + message;
        }
    }

    public abstract static class Notification {
        private final MessageSender sender;

        protected Notification(MessageSender sender) {
            this.sender = Objects.requireNonNull(sender);
        }

        protected abstract String decorate(String message);

        public String notify(String message) {
            return sender.send(decorate(message));
        }
    }

    public static final class EmailNotification extends Notification {
        public EmailNotification(MessageSender sender) {
            super(sender);
        }

        @Override
        protected String decorate(String message) {
            return "[" + message + "]";
        }
    }

    public static final class SmsNotification extends Notification {
        public SmsNotification(MessageSender sender) {
            super(sender);
        }

        @Override
        protected String decorate(String message) {
            return message.toUpperCase();
        }
    }
}
