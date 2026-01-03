package com.study.strategy;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StrategyController {

    @Resource
    private List<CustomerService> customerServices;

    @GetMapping("/{recharge}")
    public String getCustomer(@PathVariable int recharge) {
        for (CustomerService customerService : customerServices) {
            if (customerService.support(recharge)) {
                return customerService.findCustomer();
            }
        }

        return "找不到客服";
    }
}
