package com.study.strategy;

import org.springframework.stereotype.Service;

@Service
public class DefaultCustomerService implements CustomerService{

    @Override
    public UserType support() {
        return null;
    }

    @Override
    public String findCustomer() {
        return "找不到客服";
    }
}
