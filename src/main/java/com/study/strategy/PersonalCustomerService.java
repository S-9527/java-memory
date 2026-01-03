package com.study.strategy;

import org.springframework.stereotype.Service;

@Service
public class PersonalCustomerService implements CustomerService{
    @Override
    public boolean support(int recharge) {
        return recharge > 1000000;
    }

    @Override
    public String findCustomer() {
        return "专属客服";
    }
}
