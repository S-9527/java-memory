package com.study.patterns;

import java.util.Map;

public final class InterpreterExample {
    private InterpreterExample() {
    }

    public interface Expression {
        int interpret(Map<String, Integer> context);
    }

    public record NumberExpression(int value) implements Expression {
        @Override
        public int interpret(Map<String, Integer> context) {
            return value;
        }
    }

    public record VariableExpression(String name) implements Expression {
        @Override
        public int interpret(Map<String, Integer> context) {
            return context.getOrDefault(name, 0);
        }
    }

    public record AddExpression(Expression left, Expression right) implements Expression {
        @Override
        public int interpret(Map<String, Integer> context) {
            return left.interpret(context) + right.interpret(context);
        }
    }
}
