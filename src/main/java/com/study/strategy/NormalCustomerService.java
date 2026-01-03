package com.study.strategy;

import org.springframework.stereotype.Service;

@Service
public class NormalCustomerService implements CustomerService {
    @Override
    public boolean support(int recharge) {
        return recharge > 0 && recharge <= 100;
    }

    @Override
    public String findCustomer() {
        System.out.println("普通玩家客服");
        return "普通玩家客服";
    }
}
