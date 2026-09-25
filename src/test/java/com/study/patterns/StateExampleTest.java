package com.study.patterns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StateExampleTest {

    @Test
    void changesBehaviorWhenOrderStateChanges() {
        StateExample.OrderContext order = new StateExample.OrderContext();

        assertEquals("new", order.stateName());
        order.pay();
        assertEquals("paid", order.stateName());
        assertThrows(IllegalStateException.class, order::pay);
    }

    @Test
    void supportsCancellationFromNewState() {
        StateExample.OrderContext order = new StateExample.OrderContext();

        order.cancel();

        assertEquals("cancelled", order.stateName());
    }
}
