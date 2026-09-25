package com.study.patterns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VisitorExampleTest {

    @Test
    void dispatchesElementOperationsToVisitor() {
        VisitorExample.Visitor visitor = new VisitorExample.AreaVisitor();
        VisitorExample.Element circle = new VisitorExample.Circle(2);
        VisitorExample.Element square = new VisitorExample.Square(3);

        assertEquals("circle-area:" + Math.PI * 4, circle.accept(visitor));
        assertEquals("square-area:9.0", square.accept(visitor));
    }
}
