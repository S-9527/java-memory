package com.study.strategy;

import org.springframework.stereotype.Service;

@Service
public class SuperRCustomerService implements CustomerService {

    @Override
    public boolean support(int recharge) {
        return recharge > 100000 && recharge <= 1000000;
    }

    @Override
    public String findCustomer() {
        System.out.println("超R 玩家客服");
        return "超R 玩家客服";
    }
}
