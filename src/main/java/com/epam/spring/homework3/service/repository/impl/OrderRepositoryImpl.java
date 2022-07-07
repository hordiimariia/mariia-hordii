package com.epam.spring.homework3.service.repository.impl;

import com.epam.spring.homework3.service.model.Distance;
import com.epam.spring.homework3.service.model.Order;
import com.epam.spring.homework3.service.model.User;
import com.epam.spring.homework3.service.repository.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderRepositoryImpl implements OrderRepository {

    private final List<Order> list = new ArrayList<>();

    @Override
    public Order getOrder(User user, Distance distance, String parcelType) {
        return list.stream()
                .filter(order -> order.getUser().getLogin().equals(user.getLogin())
                        && order.getDistance().getFrom().equals(distance.getFrom())
                        && order.getDistance().getTo().equals(distance.getTo())
                        && order.getParcelType().equals(parcelType))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Order is not found!"));
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(list);
    }

    @Override
    public Order createOrder(Order order) {
        list.add(order);
        return order;
    }

    @Override
    public void deleteOrder(Order order) {
        list.removeIf(o -> o.equals(order));
    }
}
