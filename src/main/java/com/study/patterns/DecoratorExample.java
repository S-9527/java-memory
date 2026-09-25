package com.study.patterns;

import java.util.Objects;

public final class DecoratorExample {
    private DecoratorExample() {
    }

    public interface Message {
        String render();
    }

    public record PlainMessage(String text) implements Message {
        @Override
        public String render() {
            return text;
        }
    }

    public abstract static class MessageDecorator implements Message {
        protected final Message delegate;

        protected MessageDecorator(Message delegate) {
            this.delegate = Objects.requireNonNull(delegate);
        }
    }

    public static final class UppercaseDecorator extends MessageDecorator {
        public UppercaseDecorator(Message delegate) {
            super(delegate);
        }

        @Override
        public String render() {
            return delegate.render().toUpperCase();
        }
    }

    public static final class PrefixDecorator extends MessageDecorator {
        private final String prefix;

        public PrefixDecorator(Message delegate, String prefix) {
            super(delegate);
            this.prefix = prefix;
        }

        @Override
        public String render() {
            return prefix + delegate.render();
        }
    }
}
