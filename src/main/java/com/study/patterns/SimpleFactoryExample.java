package com.study.patterns;

import java.util.Locale;

public final class SimpleFactoryExample {
    private SimpleFactoryExample() {
    }

    public interface Product {
        String name();
    }

    public static final class Book implements Product {
        @Override
        public String name() {
            return "book";
        }
    }

    public static final class Pen implements Product {
        @Override
        public String name() {
            return "pen";
        }
    }

    public static final class ProductFactory {
        public Product create(String type) {
            return switch (type.toLowerCase(Locale.ROOT)) {
                case "book" -> new Book();
                case "pen" -> new Pen();
                default -> throw new IllegalArgumentException("未知产品类型: " + type);
            };
        }
    }
}
