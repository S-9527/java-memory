package com.study.observer.order;

import java.util.Objects;

public final class ConsoleOrderObserver implements OrderObserver {
    private final String channel;

    public ConsoleOrderObserver(String channel) {
        this.channel = Objects.requireNonNull(channel, "通知渠道不能为空");
    }

    @Override
    public void onOrderCreated(OrderCreatedEvent event) {
        System.out.printf("[%s] order %s created, amount %d%n",
                channel, event.orderId(), event.amount());
    }
}
