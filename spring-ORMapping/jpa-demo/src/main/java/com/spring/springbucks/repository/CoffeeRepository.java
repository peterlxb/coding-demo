package com.spring.springbucks.repository;

import com.spring.springbucks.model.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, Long> {

}