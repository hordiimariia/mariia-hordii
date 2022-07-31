package com.epam.spring.hw6.service;

import com.epam.spring.hw6.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    List<OrderDTO> listOrders();

    List<OrderDTO> getOrdersByUserLogin(String userLogin);

    OrderDTO getOrderById(Long id);

    OrderDTO createOrder(OrderDTO orderDTO);

    void deleteOrder(Long id);
}
