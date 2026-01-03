package com.study.strategy;

import org.springframework.stereotype.Service;

@Service
public class NormalCustomerService implements CustomerService {
    @Override
    public UserType support() {
        return UserType.Normal;
    }

    @Override
    public String findCustomer() {
        System.out.println("普通玩家客服");
        return "普通玩家客服";
    }
}
