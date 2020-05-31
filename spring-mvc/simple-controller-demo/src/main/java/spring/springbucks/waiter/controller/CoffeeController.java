package spring.springbucks.waiter.controller;

import spring.springbucks.waiter.model.Coffee;
import spring.springbucks.waiter.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * RequestMapping 可以定义在类上，也可以定义在方法上
 * 定义在类上相当于定义了一个prefix
 * */
@Controller
@RequestMapping("/coffee")
public class CoffeeController {
    @Autowired
    private CoffeeService coffeeService;

    /**
     * 这里用GetMapping做映射就是以上面的 /coffee 为基础
     * 下面的 getAll 方法返回的是一个List<Coffee>, 直接作为
     * ResponseBody 的返回结果。
     * */
    @GetMapping("/")
    @ResponseBody
    public List<Coffee> getAll() {
        return coffeeService.getAllCoffee();
    }
}
