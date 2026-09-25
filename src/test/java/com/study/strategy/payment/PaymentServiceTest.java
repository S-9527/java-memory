package com.study.strategy.payment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PaymentServiceTest {

    @Test
    void usesInitialStrategy() {
        PaymentService service = new PaymentService(new AlipayStrategy());

        assertEquals("支付宝支付成功：100 元", service.pay(100));
    }

    @Test
    void switchesToAnotherStrategy() {
        PaymentService service = new PaymentService(new AlipayStrategy());

        service.setStrategy(new WechatPayStrategy());
        assertEquals("微信支付成功：200 元", service.pay(200));

        service.setStrategy(new BankCardStrategy());
        assertEquals("银行卡支付成功：300 元", service.pay(300));
    }

    @Test
    void rejectsNullStrategy() {
        assertThrows(NullPointerException.class,
                () -> new PaymentService(null));

        PaymentService service = new PaymentService(new AlipayStrategy());
        assertThrows(NullPointerException.class,
                () -> service.setStrategy(null));
    }
}
