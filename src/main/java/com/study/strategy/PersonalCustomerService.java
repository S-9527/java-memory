package com.study.strategy;

import org.springframework.stereotype.Service;

@Service
public class PersonalCustomerService implements CustomerService{
    @Override
    public UserType support() {
        return UserType.Personal;
    }

    @Override
    public String findCustomer() {
        return "专属客服";
    }
}
