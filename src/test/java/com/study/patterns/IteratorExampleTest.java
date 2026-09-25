package com.study.patterns;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IteratorExampleTest {

    @Test
    void iteratesWithoutExposingInternalList() {
        IteratorExample.BookCollection books = new IteratorExample.BookCollection();
        books.add("Effective Java");
        books.add("Design Patterns");

        List<String> titles = new ArrayList<>();
        for (String title : books) {
            titles.add(title);
        }

        assertEquals(List.of("Effective Java", "Design Patterns"), titles);
    }
}
