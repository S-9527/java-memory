package com.study.patterns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FacadeExampleTest {

    @Test
    void coordinatesSubsystemsBehindOneFacade() {
        FacadeExample.CheckoutFacade facade = new FacadeExample.CheckoutFacade(
                new FacadeExample.AuthService(),
                new FacadeExample.PaymentService(),
                new FacadeExample.OrderRepository());

        FacadeExample.CheckoutResult success = facade.checkout("alice", 100);
        FacadeExample.CheckoutResult rejected = facade.checkout("locked", 100);

        assertEquals(new FacadeExample.CheckoutResult(
                true, true, "order-for-alice:100"), success);
        assertEquals(new FacadeExample.CheckoutResult(false, false, null), rejected);
    }
}
