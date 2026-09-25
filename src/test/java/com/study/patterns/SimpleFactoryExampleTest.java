package com.study.patterns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SimpleFactoryExampleTest {

    @Test
    void createsProductsByType() {
        SimpleFactoryExample.ProductFactory factory =
                new SimpleFactoryExample.ProductFactory();

        assertEquals("book", factory.create("BOOK").name());
        assertEquals("pen", factory.create("pen").name());
        assertThrows(IllegalArgumentException.class, () -> factory.create("unknown"));
    }
}
