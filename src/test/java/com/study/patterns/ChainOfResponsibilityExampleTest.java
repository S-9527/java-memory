package com.study.patterns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChainOfResponsibilityExampleTest {

    @Test
    void passesRequestThroughTheChain() {
        ChainOfResponsibilityExample.RequestHandler chain =
                new ChainOfResponsibilityExample.LoggingHandler(
                        new ChainOfResponsibilityExample.AuthenticationHandler(
                                new ChainOfResponsibilityExample.ValidationHandler(null)));

        assertEquals("log(pay)authvalidate", chain.handle("pay"));
    }
}
