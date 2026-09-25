package com.study.patterns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

class FlyweightExampleTest {

    @Test
    void sharesIntrinsicStyleState() {
        FlyweightExample.StyleFactory factory = new FlyweightExample.StyleFactory();

        FlyweightExample.TextStyle first = factory.get("Sans", 12);
        FlyweightExample.TextStyle second = factory.get("Sans", 12);
        FlyweightExample.TextStyle different = factory.get("Serif", 12);

        assertSame(first, second);
        assertNotSame(first, different);
        assertEquals(2, factory.cachedStyleCount());
    }
}
