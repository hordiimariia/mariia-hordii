package com.epam.spring.hw3.service.impl;

import com.epam.spring.hw3.dto.OrderDTO;
import com.epam.spring.hw3.dto.UserDTO;
import com.epam.spring.hw3.model.Order;
import com.epam.spring.hw3.model.User;
import com.epam.spring.hw3.repository.OrderRepository;
import com.epam.spring.hw3.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<OrderDTO> listOrders() {
        log.info("get list of orders");
        return orderRepository.listOrders()
                .stream()
                .map(this::mapOrderToOrderDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getOrdersByUserLogin(String userLogin) {
        log.info("get orders by User login {}", userLogin);
        return orderRepository.getOrdersByUserLogin(userLogin)
                .stream()
                .map(this::mapOrderToOrderDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrderById(String orderId) {
        log.info("getOrder by id {}", orderId);
        Order order = orderRepository.getOrderById(orderId);
        return mapOrderToOrderDTO(order);
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        log.info("create order of user {} from {} to {}",
                orderDTO.getUserDTO().getLogin(),
                orderDTO.getCityFrom(),
                orderDTO.getCityTo());
        Order order = mapOrderDTOtoOrder(orderDTO);
        order = orderRepository.createOrder(order);
        return mapOrderToOrderDTO(order);
    }

    @Override
    public void deleteOrder(String orderId) {
        log.info("deleteOrder with id {}", orderId);
        orderRepository.deleteOrder(orderId);
    }

    private OrderDTO mapOrderToOrderDTO(Order order){
        return OrderDTO.builder()
                .orderId(order.getOrderId())
                .cityFrom(order.getCityFrom())
                .cityTo(order.getCityTo())
                .parcelType(order.getParcelType())
                .userDTO(UserDTO.builder()
                        .firstName(order.getUser().getFirstName())
                        .lastName(order.getUser().getLastName())
                        .login(order.getUser().getLogin())
                        .build())
                .build();
    }

    private Order mapOrderDTOtoOrder(OrderDTO orderDTO){
        return Order.builder()
                .orderId(orderDTO.getOrderId())
                .cityFrom(orderDTO.getCityFrom())
                .cityTo(orderDTO.getCityTo())
                .parcelType(orderDTO.getParcelType())
                .user(User.builder()
                        .firstName(orderDTO.getUserDTO().getFirstName())
                        .lastName(orderDTO.getUserDTO().getLastName())
                        .login(orderDTO.getUserDTO().getLogin())
                        .password(orderDTO.getUserDTO().getPassword())
                        .build())
                .build();
    }
}
