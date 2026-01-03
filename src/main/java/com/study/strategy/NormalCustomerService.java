package com.study.strategy;

import org.springframework.stereotype.Service;

@Service
@SupportUserType(UserType.Normal)
public class NormalCustomerService implements CustomerService {
    @Override
    public String findCustomer() {
        System.out.println("普通玩家客服");
        return "普通玩家客服";
    }
}
