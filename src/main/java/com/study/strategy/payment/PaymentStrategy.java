package com.study.strategy.payment;

@FunctionalInterface
public interface PaymentStrategy {
    String pay(int amount);
}
