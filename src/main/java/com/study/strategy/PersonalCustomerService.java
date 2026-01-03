package com.study.strategy;

import org.springframework.stereotype.Service;

@Service
@SupportUserType(UserType.Personal)
public class PersonalCustomerService implements CustomerService{
    @Override
    public String findCustomer() {
        return "专属客服";
    }
}
