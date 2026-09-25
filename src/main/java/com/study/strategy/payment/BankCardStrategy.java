package com.study.strategy.payment;

public final class BankCardStrategy implements PaymentStrategy {
    @Override
    public String pay(int amount) {
        return "银行卡支付成功：" + amount + " 元";
    }
}
