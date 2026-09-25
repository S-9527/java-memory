package com.study.patterns;

public final class SingletonExample {
    private SingletonExample() {
    }

    public static final class AppConfig {
        private static final class Holder {
            private static final AppConfig INSTANCE = new AppConfig("dev");
        }

        private final String environment;

        private AppConfig(String environment) {
            this.environment = environment;
        }

        public static AppConfig getInstance() {
            return Holder.INSTANCE;
        }

        public String environment() {
            return environment;
        }
    }
}
