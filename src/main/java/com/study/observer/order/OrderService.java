package com.study.observer.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class OrderService {
    private final List<OrderObserver> observers = new ArrayList<>();

    public void subscribe(OrderObserver observer) {
        observers.add(Objects.requireNonNull(observer, "观察者不能为空"));
    }

    public boolean unsubscribe(OrderObserver observer) {
        return observers.remove(observer);
    }

    public void placeOrder(String orderId, int amount) {
        OrderCreatedEvent event = new OrderCreatedEvent(orderId, amount);
        for (OrderObserver observer : List.copyOf(observers)) {
            observer.onOrderCreated(event);
        }
    }
}
