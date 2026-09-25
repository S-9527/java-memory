package com.study.patterns;

import java.util.Objects;

public final class FacadeExample {
    private FacadeExample() {
    }

    public record CheckoutResult(boolean authenticated, boolean paid, String orderId) {
    }

    public static final class AuthService {
        public boolean login(String user) {
            return !"locked".equals(user);
        }
    }

    public static final class PaymentService {
        public String charge(String user, int amount) {
            return user + ":" + amount;
        }
    }

    public static final class OrderRepository {
        public String save(String payment) {
            return "order-for-" + payment;
        }
    }

    public static final class CheckoutFacade {
        private final AuthService authService;
        private final PaymentService paymentService;
        private final OrderRepository orderRepository;

        public CheckoutFacade(
                AuthService authService,
                PaymentService paymentService,
                OrderRepository orderRepository) {
            this.authService = Objects.requireNonNull(authService);
            this.paymentService = Objects.requireNonNull(paymentService);
            this.orderRepository = Objects.requireNonNull(orderRepository);
        }

        public CheckoutResult checkout(String user, int amount) {
            if (!authService.login(user)) {
                return new CheckoutResult(false, false, null);
            }
            String payment = paymentService.charge(user, amount);
            return new CheckoutResult(true, true, orderRepository.save(payment));
        }
    }
}
