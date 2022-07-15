package com.epam.spring.hw3.repository;

import com.epam.spring.hw3.model.Order;

import java.util.List;

public interface OrderRepository {

    List<Order> listOrders();

    List<Order> getOrdersByUserLogin(String userLogin);

    Order getOrderById(String orderId);

    Order createOrder(Order order);

    void deleteOrder(String orderId);
}
