package com.study.strategy.payment;

public final class WechatPayStrategy implements PaymentStrategy {
    @Override
    public String pay(int amount) {
        return "微信支付成功：" + amount + " 元";
    }
}
