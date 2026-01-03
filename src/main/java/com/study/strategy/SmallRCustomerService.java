package com.study.strategy;

import org.springframework.stereotype.Service;

@Service
public class SmallRCustomerService implements CustomerService {

    @Override
    public UserType support() {
        return UserType.Small;
    }

    @Override
    public String findCustomer() {
        System.out.println("小R 玩家客服");
        return "小R 玩家客服";
    }
}
