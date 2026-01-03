package com.study.strategy;

import org.springframework.stereotype.Service;

@Service
@SupportUserType(UserType.Small)
public class SmallRCustomerService implements CustomerService {

    @Override
    public String findCustomer() {
        System.out.println("小R 玩家客服");
        return "小R 玩家客服";
    }
}
