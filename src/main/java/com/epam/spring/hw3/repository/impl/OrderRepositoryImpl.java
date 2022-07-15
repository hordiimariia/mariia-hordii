package com.epam.spring.hw3.repository.impl;

import com.epam.spring.hw3.model.Order;
import com.epam.spring.hw3.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class OrderRepositoryImpl implements OrderRepository {

    private final List<Order> list = new ArrayList<>();

    @Override
    public List<Order> listOrders() {
        log.info("get listOrders");
        return new ArrayList<>(list);
    }

    @Override
    public List<Order> getOrdersByUserLogin(String userLogin) {
        log.info("getOrdersByUserLogin {}", userLogin);
        return list.stream()
                .filter(order -> order.getUser().getLogin().equals(userLogin))
                .collect(Collectors.toList());
    }

    @Override
    public Order getOrderById(String orderId) {
        log.info("getOrderById {}", orderId);
        return list.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Order is not found!"));
    }

    @Override
    public Order createOrder(Order order) {
        log.info("createOrder {}", order);
        list.add(order);
        return order;
    }

    @Override
    public void deleteOrder(String orderId) {
        log.info("deleteOrder {}", orderId);
        list.removeIf(u -> u.getOrderId().equals(orderId));
    }
}
