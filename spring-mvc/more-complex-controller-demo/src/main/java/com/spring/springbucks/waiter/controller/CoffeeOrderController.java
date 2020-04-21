package com.spring.springbucks.waiter.controller;

import com.spring.springbucks.waiter.controller.request.NewOrderRequest;
import com.spring.springbucks.waiter.model.Coffee;
import com.spring.springbucks.waiter.model.CoffeeOrder;
import com.spring.springbucks.waiter.service.CoffeeOrderService;
import com.spring.springbucks.waiter.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Slf4j
public class CoffeeOrderController {
    @Autowired
    private CoffeeOrderService orderService;
    @Autowired
    private CoffeeService coffeeService;

    @GetMapping("/{id}")
    public CoffeeOrder getOrder(@PathVariable Long id) {
        return orderService.get(id);
    }

    /*
    * create coffee order
    * */
    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CoffeeOrder create(@RequestBody NewOrderRequest newOrder) {
        log.info("Receive new order: {}", newOrder);
        Coffee[] cofferList = coffeeService.getCoffeeByName(newOrder.getItems())
                .toArray(new Coffee[] {});

        return orderService.createOrder(newOrder.getCustomer(), cofferList);
    };
}

