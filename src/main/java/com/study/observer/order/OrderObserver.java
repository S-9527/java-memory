package com.study.observer.order;

@FunctionalInterface
public interface OrderObserver {
    void onOrderCreated(OrderCreatedEvent event);
}
