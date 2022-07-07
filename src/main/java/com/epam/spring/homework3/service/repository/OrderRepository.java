package com.epam.spring.homework3.service.repository;

import com.epam.spring.homework3.service.model.Distance;
import com.epam.spring.homework3.service.model.Order;
import com.epam.spring.homework3.service.model.User;

import java.util.List;

public interface OrderRepository {
    Order getOrder(User user, Distance distance, String parcelType);
    List<Order> getAllOrders();

    Order createOrder(Order order);
    void deleteOrder(Order order);
}
