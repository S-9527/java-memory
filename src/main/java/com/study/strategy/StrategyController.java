package com.study.strategy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StrategyController {

    @GetMapping("/{recharge}")
    public String getCustomer(@PathVariable int recharge) {
        if (recharge > 0 && recharge <= 100) {
            return "普通玩家客服";
        }

        if (recharge > 100 && recharge <= 10000) {
            return "小R 玩家客服";
        }

        if (recharge > 10000 && recharge <= 100000) {
            return "大R 玩家客服";
        }

        if (recharge > 100000) {
            return "专属客服";
        }

        return "找不到客服";
    }
}
