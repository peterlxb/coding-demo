package com.spring.springbucks.service;

import com.spring.springbucks.model.Coffee;
import com.spring.springbucks.model.CoffeeOrder;
import com.spring.springbucks.model.OrderState;
import com.spring.springbucks.repository.CoffeeOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;

@Slf4j
@Service
@Transactional
public class CoffeeOrderService {
    @Autowired
    CoffeeOrderRepository orderRepository;

    /**
     *  创建新订单
     * */
    public CoffeeOrder createOrder(String customer, Coffee ...coffees) {
        CoffeeOrder order = CoffeeOrder.builder()
                .customer(customer)
                .items(new ArrayList<>(Arrays.asList(coffees)))
                .state(OrderState.INIT)
                .build();

        CoffeeOrder saved = orderRepository.save(order);
        log.info("New Order: {}", saved);
        return saved;
    }

    /**
     * 更新订单状态
     * */
    public boolean updateOrder(CoffeeOrder order, OrderState state) {
        if (state.compareTo(order.getState()) <= 0) {
            log.warn("wrong order state: {}, {}", state, order.getState());
            return false;
        }

        order.setState(state);
        orderRepository.save(order);
        log.info("Updated Order: {}", order);
        return true;
    }
}