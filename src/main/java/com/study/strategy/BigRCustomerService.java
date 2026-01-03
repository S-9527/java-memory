package com.study.strategy;

import org.springframework.stereotype.Service;

@Service
public class BigRCustomerService implements CustomerService {

    @Override
    public boolean support(int recharge) {
        return recharge > 10000 && recharge <= 100000;
    }

    @Override
    public String findCustomer() {
        System.out.println("大R 玩家客服");
        return "大R 玩家客服";
    }
}
