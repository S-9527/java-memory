package com.study.patterns;

import java.util.List;

public final class AbstractFactoryExample {
    private AbstractFactoryExample() {
    }

    public interface Button {
        String render();
    }

    public interface Checkbox {
        String render();
    }

    public interface UiFactory {
        Button createButton();

        Checkbox createCheckbox();
    }

    public static final class DarkButton implements Button {
        @Override
        public String render() {
            return "dark-button";
        }
    }

    public static final class DarkCheckbox implements Checkbox {
        @Override
        public String render() {
            return "dark-checkbox";
        }
    }

    public static final class LightButton implements Button {
        @Override
        public String render() {
            return "light-button";
        }
    }

    public static final class LightCheckbox implements Checkbox {
        @Override
        public String render() {
            return "light-checkbox";
        }
    }

    public static final class DarkUiFactory implements UiFactory {
        @Override
        public Button createButton() {
            return new DarkButton();
        }

        @Override
        public Checkbox createCheckbox() {
            return new DarkCheckbox();
        }
    }

    public static final class LightUiFactory implements UiFactory {
        @Override
        public Button createButton() {
            return new LightButton();
        }

        @Override
        public Checkbox createCheckbox() {
            return new LightCheckbox();
        }
    }

    public static final class UiApplication {
        private final UiFactory factory;

        public UiApplication(UiFactory factory) {
            this.factory = factory;
        }

        public List<String> render() {
            return List.of(
                    factory.createButton().render(),
                    factory.createCheckbox().render());
        }
    }
}
