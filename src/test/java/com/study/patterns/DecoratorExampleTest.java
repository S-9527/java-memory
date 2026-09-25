package com.study.patterns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecoratorExampleTest {

    @Test
    void combinesDecoratorsAtRuntime() {
        DecoratorExample.Message message = new DecoratorExample.PrefixDecorator(
                new DecoratorExample.UppercaseDecorator(
                        new DecoratorExample.PlainMessage("java")),
                "> ");

        assertEquals("> JAVA", message.render());
    }
}
