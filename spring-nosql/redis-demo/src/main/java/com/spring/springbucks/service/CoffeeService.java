package com.spring.springbucks.service;

import com.spring.springbucks.model.Coffee;
import com.spring.springbucks.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@Slf4j
@Service
public class CoffeeService {
    private static final String CACHE = "springbucks-coffee";
    @Autowired
    CoffeeRepository coffeeRepository;
    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 返回所有coffee
     * */
    public List<Coffee> findAllCoffee() {
        return coffeeRepository.findAll();
    }

    public Optional<Coffee> findOneCoffee(String name) {
        HashOperations<String, String, Coffee> hashOperations = redisTemplate.opsForHash();
        if (redisTemplate.hasKey(CACHE) && hashOperations.hasKey(CACHE, name)) {
            log.info("Get coffee from redis: {} ", name);
            return Optional.of(hashOperations.get(CACHE, name));
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", exact().ignoreCase());

        Optional<Coffee> coffee = coffeeRepository.findOne(
                Example.of(Coffee.builder().name(name).build(), matcher));
        log.info("Coffee Found: {}", coffee);

        if (coffee.isPresent()) {
            log.info("Put coffee to redis: {}", name);
            hashOperations.put(CACHE, name, coffee.get());
            // 设置数据失效时间
            redisTemplate.expire(CACHE, 3, TimeUnit.MINUTES);
        }

        return coffee;
    }
}