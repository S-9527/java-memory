package com.study.strategy.payment;

public final class AlipayStrategy implements PaymentStrategy {
    @Override
    public String pay(int amount) {
        return "支付宝支付成功：" + amount + " 元";
    }
}
