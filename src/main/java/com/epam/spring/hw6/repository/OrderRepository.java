package com.epam.spring.hw6.repository;

import com.epam.spring.hw6.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByUserLogin(String userLogin);
}
