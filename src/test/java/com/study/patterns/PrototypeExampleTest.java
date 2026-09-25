package com.study.patterns;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

class PrototypeExampleTest {

    @Test
    void copiesDocumentWithoutSharingMutableTags() {
        PrototypeExample.Document original =
                new PrototypeExample.Document("Design Patterns", List.of("java"));
        PrototypeExample.Document copy = original.copy();

        assertNotSame(original, copy);
        assertNotSame(original.tags(), copy.tags());
        assertEquals(original.title(), copy.title());

        copy.title("Practical Patterns");
        copy.tags().add("learning");
        assertEquals("Design Patterns", original.title());
        assertEquals(List.of("java"), original.tags());
    }
}
