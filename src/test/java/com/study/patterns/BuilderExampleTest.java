package com.study.patterns;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BuilderExampleTest {

    @Test
    void buildsRequestWithDefaultsAndCustomValues() {
        BuilderExample.HttpRequest request = BuilderExample.HttpRequest.builder()
                .url("https://example.com")
                .method("POST")
                .header("Accept", "application/json")
                .body("{}")
                .build();

        assertEquals("POST", request.method());
        assertEquals("https://example.com", request.url());
        assertEquals(Map.of("Accept", "application/json"), request.headers());
        assertEquals("{}", request.body());
    }

    @Test
    void requiresUrl() {
        assertThrows(NullPointerException.class,
                () -> BuilderExample.HttpRequest.builder().build());
    }
}
