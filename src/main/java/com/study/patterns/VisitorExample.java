package com.study.patterns;

public final class VisitorExample {
    private VisitorExample() {
    }

    public interface Visitor {
        String visit(Circle circle);

        String visit(Square square);
    }

    public interface Element {
        String accept(Visitor visitor);
    }

    public record Circle(double radius) implements Element {
        @Override
        public String accept(Visitor visitor) {
            return visitor.visit(this);
        }
    }

    public record Square(double side) implements Element {
        @Override
        public String accept(Visitor visitor) {
            return visitor.visit(this);
        }
    }

    public static final class AreaVisitor implements Visitor {
        @Override
        public String visit(Circle circle) {
            return "circle-area:" + Math.PI * circle.radius() * circle.radius();
        }

        @Override
        public String visit(Square square) {
            return "square-area:" + square.side() * square.side();
        }
    }
}
