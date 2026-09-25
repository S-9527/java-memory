package com.study.patterns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class SingletonExampleTest {

    @Test
    void returnsTheSameConfigurationInstance() {
        SingletonExample.AppConfig first = SingletonExample.AppConfig.getInstance();
        SingletonExample.AppConfig second = SingletonExample.AppConfig.getInstance();

        assertSame(first, second);
        assertEquals("dev", first.environment());
    }
}
