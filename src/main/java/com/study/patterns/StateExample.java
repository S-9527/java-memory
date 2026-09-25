package com.study.patterns;

import java.util.Objects;

public final class StateExample {
    private StateExample() {
    }

    public interface OrderState {
        void pay(OrderContext context);

        void cancel(OrderContext context);

        String name();
    }

    public static final class NewOrderState implements OrderState {
        @Override
        public void pay(OrderContext context) {
            context.changeState(new PaidOrderState());
        }

        @Override
        public void cancel(OrderContext context) {
            context.changeState(new CancelledOrderState());
        }

        @Override
        public String name() {
            return "new";
        }
    }

    public static final class PaidOrderState implements OrderState {
        @Override
        public void pay(OrderContext context) {
            throw new IllegalStateException("已支付订单不能重复支付");
        }

        @Override
        public void cancel(OrderContext context) {
            throw new IllegalStateException("已支付订单不能直接取消");
        }

        @Override
        public String name() {
            return "paid";
        }
    }

    public static final class CancelledOrderState implements OrderState {
        @Override
        public void pay(OrderContext context) {
            throw new IllegalStateException("已取消订单不能支付");
        }

        @Override
        public void cancel(OrderContext context) {
            throw new IllegalStateException("订单已经取消");
        }

        @Override
        public String name() {
            return "cancelled";
        }
    }

    public static final class OrderContext {
        private OrderState state = new NewOrderState();

        public void pay() {
            state.pay(this);
        }

        public void cancel() {
            state.cancel(this);
        }

        public String stateName() {
            return state.name();
        }

        public void changeState(OrderState state) {
            this.state = Objects.requireNonNull(state);
        }
    }
}
