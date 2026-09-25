package com.study.strategy.payment;

import java.util.Objects;

public final class PaymentService {
    private PaymentStrategy strategy;

    public PaymentService(PaymentStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy, "策略不能为空");
    }

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy, "策略不能为空");
    }

    public String pay(int amount) {
        return strategy.pay(amount);
    }
}
