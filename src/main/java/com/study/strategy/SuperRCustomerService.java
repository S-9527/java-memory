package com.study.strategy;

import org.springframework.stereotype.Service;

@Service
@SupportUserType(UserType.Super)
public class SuperRCustomerService implements CustomerService {
    @Override
    public String findCustomer() {
        System.out.println("超R 玩家客服");
        return "超R 玩家客服";
    }
}
