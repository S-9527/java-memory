package com.study.patterns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdapterExampleTest {

    @Test
    void adaptsLegacyPaymentToModernInterface() {
        AdapterExample.ModernPaymentGateway gateway =
                new AdapterExample.LegacyPaymentAdapter(
                        new AdapterExample.LegacyPaymentGateway());

        assertEquals("legacy:1250", gateway.pay(1250));
    }
}
