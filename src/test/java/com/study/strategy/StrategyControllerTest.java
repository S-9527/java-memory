package com.study.strategy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StrategyController.class)
class StrategyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private List<CustomerService> customerServices; // 模拟的 List 对象

    // 测试普通玩家（0 < recharge ≤ 100）
    @Test
    void getCustomer_Recharge50_ReturnNormalCustomer() throws Exception {
        // 1. 模拟普通玩家客服
        CustomerService normalService = mock(NormalCustomerService.class);
        when(normalService.support()).thenReturn(UserType.Normal);
        when(normalService.findCustomer()).thenReturn("普通玩家客服");

        // 2. 模拟其他客服不匹配
        CustomerService smallRService = mock(SmallRCustomerService.class);

        // 3. 关键修正：为 mock List 设置迭代行为，使其返回我们准备的客服实例
        List<CustomerService> mockServices = Arrays.asList(normalService, smallRService);
        Iterator<CustomerService> iterator = mockServices.iterator();
        when(customerServices.iterator()).thenReturn(iterator); // 模拟迭代器

        // 4. 执行测试
        mockMvc.perform(get("/50"))
                .andExpect(status().isOk())
                .andExpect(content().string("普通玩家客服"));
    }

    // 测试小R玩家（100 < recharge ≤ 10000）
    @Test
    void getCustomer_Recharge5000_ReturnSmallRCustomer() throws Exception {
        CustomerService smallRService = mock(CustomerService.class);
        when(smallRService.support()).thenReturn(UserType.Small);
        when(smallRService.findCustomer()).thenReturn("小R 玩家客服");

        List<CustomerService> mockServices = List.of(smallRService);
        Iterator<CustomerService> iterator = mockServices.iterator();
        when(customerServices.iterator()).thenReturn(iterator); // 模拟迭代器

        mockMvc.perform(get("/5000"))
                .andExpect(status().isOk())
                .andExpect(content().string("小R 玩家客服"));
    }

    // 测试大R玩家（10000 < recharge ≤ 100000）
    @Test
    void getCustomer_Recharge50000_ReturnBigRCustomer() throws Exception {
        CustomerService bigRService = mock(CustomerService.class);
        when(bigRService.support()).thenReturn(UserType.Big);
        when(bigRService.findCustomer()).thenReturn("大R 玩家客服");

        List<CustomerService> mockServices = List.of(bigRService);
        Iterator<CustomerService> iterator = mockServices.iterator();
        when(customerServices.iterator()).thenReturn(iterator); // 模拟迭代器

        mockMvc.perform(get("/50000"))
                .andExpect(status().isOk())
                .andExpect(content().string("大R 玩家客服"));
    }

    // 测试超R玩家（100000 < recharge ≤ 1000000）
    @Test
    void getCustomer_Recharge500000_ReturnSuperRCustomer() throws Exception {
        CustomerService superRService = mock(CustomerService.class);
        when(superRService.support()).thenReturn(UserType.Super);
        when(superRService.findCustomer()).thenReturn("超R 玩家客服");

        List<CustomerService> mockServices = List.of(superRService);
        Iterator<CustomerService> iterator = mockServices.iterator();
        when(customerServices.iterator()).thenReturn(iterator); // 模拟迭代器

        mockMvc.perform(get("/500000"))
                .andExpect(status().isOk())
                .andExpect(content().string("超R 玩家客服"));
    }

    // 测试专属玩家（recharge > 1000000）
    @Test
    void getCustomer_Recharge2000000_ReturnPersonalCustomer() throws Exception {
        CustomerService personalService = mock(CustomerService.class);
        when(personalService.support()).thenReturn(UserType.Personal);
        when(personalService.findCustomer()).thenReturn("专属客服");

        List<CustomerService> mockServices = List.of(personalService);
        Iterator<CustomerService> iterator = mockServices.iterator();
        when(customerServices.iterator()).thenReturn(iterator); // 模拟迭代器

        mockMvc.perform(get("/2000000"))
                .andExpect(status().isOk())
                .andExpect(content().string("专属客服"));
    }

    // 测试无匹配客服（recharge ≤ 0）
    @Test
    void getCustomer_Recharge0_ReturnNotFound() throws Exception {
        // 1. 模拟客服不支持 recharge=0
        CustomerService normalService = mock(NormalCustomerService.class);
        when(normalService.support()).thenReturn(null);

        // 2. 为 mock List 设置迭代行为
        List<CustomerService> mockServices = List.of(normalService);
        Iterator<CustomerService> iterator = mockServices.iterator();
        when(customerServices.iterator()).thenReturn(iterator);

        // 3. 执行测试
        mockMvc.perform(get("/0"))
                .andExpect(status().isOk())
                .andExpect(content().string("找不到客服"));
    }

    // 其他测试方法（小R、大R等）按同样逻辑修正...
}