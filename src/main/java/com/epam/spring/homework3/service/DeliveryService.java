package com.epam.spring.homework3.service;

import com.epam.spring.homework3.controller.dto.DistanceDTO;
import com.epam.spring.homework3.controller.dto.OrderDTO;
import com.epam.spring.homework3.service.model.Distance;
import com.epam.spring.homework3.service.model.Order;
import com.epam.spring.homework3.service.model.User;

import java.util.List;

public interface DeliveryService {
    DistanceDTO getDistance(int id);
    List<DistanceDTO> getAllDistances();

    DistanceDTO createDistance(DistanceDTO distanceDTO);
    void deleteDistance(int id);


    OrderDTO getOrder(User user, Distance distance, String parcelType);
    List<OrderDTO> getAllOrders();
    OrderDTO createOrder(OrderDTO orderDTO);
    void deleteOrder(Order order);
}
