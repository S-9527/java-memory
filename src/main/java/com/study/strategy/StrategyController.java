package com.study.strategy;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
public class StrategyController {

    private Map<UserType, CustomerService> customerServiceMap;

    @Resource
    private DefaultCustomerService defaultCustomerService;

    @GetMapping("/{recharge}")
    public String getCustomer(@PathVariable int recharge) {
        UserType userType = UserType.typeOf(recharge);
        CustomerService customerService = customerServiceMap.getOrDefault(userType, defaultCustomerService);
        return customerService.findCustomer();
    }

    @Autowired
    public void setCustomerServiceMap(List<CustomerService> customerServiceList) {
        this.customerServiceMap = customerServiceList.stream()
                .filter(customerService -> customerService.support() != null)
                .collect(Collectors.toMap(CustomerService::support, Function.identity()));

        if (this.customerServiceMap.size() != UserType.values().length) {
            throw new IllegalArgumentException("存在用户类型没有对应的处理器");
        }
    }
}
