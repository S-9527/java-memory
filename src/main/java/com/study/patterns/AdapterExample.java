package com.study.patterns;

import java.util.Objects;

public final class AdapterExample {
    private AdapterExample() {
    }

    public interface ModernPaymentGateway {
        String pay(int amountInCents);
    }

    public static final class LegacyPaymentGateway {
        public String charge(int amountInCents) {
            return "legacy:" + amountInCents;
        }
    }

    public static final class LegacyPaymentAdapter implements ModernPaymentGateway {
        private final LegacyPaymentGateway legacyGateway;

        public LegacyPaymentAdapter(LegacyPaymentGateway legacyGateway) {
            this.legacyGateway = Objects.requireNonNull(legacyGateway);
        }

        @Override
        public String pay(int amountInCents) {
            return legacyGateway.charge(amountInCents);
        }
    }
}
