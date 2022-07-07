package com.epam.spring.homework3.service.impl;

import com.epam.spring.homework3.controller.dto.DistanceDTO;
import com.epam.spring.homework3.controller.dto.OrderDTO;
import com.epam.spring.homework3.service.DeliveryService;
import com.epam.spring.homework3.service.model.Distance;
import com.epam.spring.homework3.service.model.Order;
import com.epam.spring.homework3.service.model.User;
import com.epam.spring.homework3.service.repository.DistanceRepository;
import com.epam.spring.homework3.service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DistanceRepository distanceRepository;
    private final OrderRepository orderRepository;

    @Override
    public DistanceDTO getDistance(int id) {
        Distance distance = distanceRepository.getDistance(id);
        return mapDistanceToDistanceDTO(distance);
    }

    @Override
    public List<DistanceDTO> getAllDistances() {
        return distanceRepository.getAllDistances()
                .stream()
                .map(this::mapDistanceToDistanceDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DistanceDTO createDistance(DistanceDTO distanceDTO) {
        Distance distance = mapDistanceDTOToDistance(distanceDTO);
        distance = distanceRepository.createDistance(distance);
        return mapDistanceToDistanceDTO(distance);
    }

    @Override
    public void deleteDistance(int id) {
        distanceRepository.deleteDistance(id);
    }

    @Override
    public OrderDTO getOrder(User user, Distance distance, String parcelType) {
        Order order = orderRepository.getOrder(user, distance, parcelType);
        return mapOrderToOrderDTO(order);
    }


    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.getAllOrders()
                .stream()
                .map(this::mapOrderToOrderDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = mapOrderDTOToOrder(orderDTO);
        order = orderRepository.createOrder(order);
        return mapOrderToOrderDTO(order);
    }

    @Override
    public void deleteOrder(Order order) {
        orderRepository.deleteOrder(order);
    }

    private DistanceDTO mapDistanceToDistanceDTO(Distance distance) {
        return DistanceDTO.builder()
                .id(distance.getId())
                .from(distance.getFrom())
                .to(distance.getTo())
                .distance(distance.getDistance())
                .build();
    }

    private OrderDTO mapOrderToOrderDTO(Order order) {
        return OrderDTO.builder()
                .id(order.getId())
                .user(order.getUser())
                .distance(order.getDistance())
                .parcelType(order.getParcelType())
                .weight(order.getWeight())
                .length(order.getLength())
                .width(order.getWidth())
                .height(order.getHeight())
                .deliveryTimeInDays(order.getDeliveryTimeInDays())
                .price(order.getPrice())
                .status(order.getStatus())
                .build();
    }

    private Distance mapDistanceDTOToDistance(DistanceDTO distanceDTO) {
        return Distance.builder()
                .id(distanceDTO.getId())
                .from(distanceDTO.getFrom())
                .to(distanceDTO.getTo())
                .distance(distanceDTO.getDistance())
                .build();
    }

    private Order mapOrderDTOToOrder(OrderDTO orderDTO) {
        return Order.builder()
                .id(orderDTO.getId())
                .user(orderDTO.getUser())
                .distance(orderDTO.getDistance())
                .parcelType(orderDTO.getParcelType())
                .weight(orderDTO.getWeight())
                .length(orderDTO.getLength())
                .width(orderDTO.getWidth())
                .height(orderDTO.getHeight())
                .deliveryTimeInDays(orderDTO.getDeliveryTimeInDays())
                .price(orderDTO.getPrice())
                .status(orderDTO.getStatus())
                .build();
    }

}
