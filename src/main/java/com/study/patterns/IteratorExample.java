package com.study.patterns;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class IteratorExample {
    private IteratorExample() {
    }

    public static final class BookCollection implements Iterable<String> {
        private final List<String> books = new ArrayList<>();

        public void add(String book) {
            books.add(book);
        }

        @Override
        public Iterator<String> iterator() {
            return books.iterator();
        }
    }
}
