package com.study.strategy;

import java.util.function.IntPredicate;

public enum UserType {
    Normal(recharge -> recharge > 0 && recharge <= 100),
    Small(recharge ->  recharge > 100 && recharge <= 10000),
    Big(recharge ->  recharge > 10000 && recharge <= 100000),
    Super(recharge ->  recharge > 100000 && recharge <= 1000000),
    Personal(recharge -> recharge > 1000000);

    private final IntPredicate support;

    UserType(IntPredicate support) {
        this.support = support;
    }

    public static UserType typeOf(int recharge) {
        for (UserType value : values()) {
            if (value.support.test(recharge)) {
                return value;
            }
        }

        return null;
    }
}
