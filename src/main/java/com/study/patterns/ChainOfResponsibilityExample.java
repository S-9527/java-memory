package com.study.patterns;

public final class ChainOfResponsibilityExample {
    private ChainOfResponsibilityExample() {
    }

    public interface RequestHandler {
        String handle(String request);
    }

    public abstract static class BaseHandler implements RequestHandler {
        private final RequestHandler next;

        protected BaseHandler(RequestHandler next) {
            this.next = next;
        }

        @Override
        public final String handle(String request) {
            String result = process(request);
            if (next != null) {
                result += next.handle(request);
            }
            return result;
        }

        protected abstract String process(String request);
    }

    public static final class LoggingHandler extends BaseHandler {
        public LoggingHandler(RequestHandler next) {
            super(next);
        }

        @Override
        protected String process(String request) {
            return "log(" + request + ")";
        }
    }

    public static final class AuthenticationHandler extends BaseHandler {
        public AuthenticationHandler(RequestHandler next) {
            super(next);
        }

        @Override
        protected String process(String request) {
            return "auth";
        }
    }

    public static final class ValidationHandler extends BaseHandler {
        public ValidationHandler(RequestHandler next) {
            super(next);
        }

        @Override
        protected String process(String request) {
            return "validate";
        }
    }
}
