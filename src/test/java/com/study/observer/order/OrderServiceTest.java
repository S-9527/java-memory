package com.study.observer.order;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderServiceTest {

    @Test
    void notifiesAllSubscribers() {
        List<OrderCreatedEvent> received = new ArrayList<>();
        OrderService service = new OrderService();
        service.subscribe(received::add);
        service.subscribe(received::add);

        service.placeOrder("order-001", 100);

        assertEquals(List.of(
                new OrderCreatedEvent("order-001", 100),
                new OrderCreatedEvent("order-001", 100)), received);
    }

    @Test
    void unsubscribesObserver() {
        List<OrderCreatedEvent> received = new ArrayList<>();
        OrderObserver observer = received::add;
        OrderService service = new OrderService();
        service.subscribe(observer);

        assertTrue(service.unsubscribe(observer));
        service.placeOrder("order-002", 200);

        assertTrue(received.isEmpty());
        assertFalse(service.unsubscribe(observer));
    }

    @Test
    void rejectsNullObserver() {
        OrderService service = new OrderService();

        assertThrows(NullPointerException.class,
                () -> service.subscribe(null));
    }

    @Test
    void eventContainsOrderData() {
        OrderCreatedEvent event = new OrderCreatedEvent("order-003", 300);

        assertEquals("order-003", event.orderId());
        assertEquals(300, event.amount());
    }
}
