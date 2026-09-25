package com.study.observer.order;

public record OrderCreatedEvent(String orderId, int amount) {
}
