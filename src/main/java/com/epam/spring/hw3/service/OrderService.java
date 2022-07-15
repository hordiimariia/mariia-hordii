package com.epam.spring.hw3.service;

import com.epam.spring.hw3.dto.OrderDTO;
import java.util.List;

public interface OrderService {

    List<OrderDTO> listOrders();

    List<OrderDTO> getOrdersByUserLogin(String userLogin);

    OrderDTO getOrderById(String orderId);

    OrderDTO createOrder(OrderDTO orderDTO);

    void deleteOrder(String orderId);
}
