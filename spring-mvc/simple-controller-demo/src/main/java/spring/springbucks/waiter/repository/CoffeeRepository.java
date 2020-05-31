package spring.springbucks.waiter.repository;

import spring.springbucks.waiter.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
    // 根据名字来做查询
    List<Coffee> findByNameInOrderById(List<String> list);
}
