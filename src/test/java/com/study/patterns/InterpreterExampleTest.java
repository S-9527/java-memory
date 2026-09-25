package com.study.patterns;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InterpreterExampleTest {

    @Test
    void evaluatesExpressionTree() {
        InterpreterExample.Expression expression = new InterpreterExample.AddExpression(
                new InterpreterExample.NumberExpression(2),
                new InterpreterExample.VariableExpression("x"));

        assertEquals(7, expression.interpret(Map.of("x", 5)));
    }
}
