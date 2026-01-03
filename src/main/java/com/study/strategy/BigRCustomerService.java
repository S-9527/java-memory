package com.study.strategy;

import org.springframework.stereotype.Service;

@Service
@SupportUserType(UserType.Big)
public class BigRCustomerService implements CustomerService {
    @Override
    public String findCustomer() {
        System.out.println("大R 玩家客服");
        return "大R 玩家客服";
    }
}
