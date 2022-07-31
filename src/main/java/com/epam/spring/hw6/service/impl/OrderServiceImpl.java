package com.epam.spring.hw6.service.impl;

import com.epam.spring.hw6.dto.OrderDTO;
import com.epam.spring.hw6.dto.UserDTO;
import com.epam.spring.hw6.exception.EntityNotFoundException;
import com.epam.spring.hw6.model.Order;
import com.epam.spring.hw6.repository.OrderRepository;
import com.epam.spring.hw6.repository.UserRepository;
import com.epam.spring.hw6.service.OrderService;
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
    private final UserRepository userRepository;

    @Override
    public List<OrderDTO> listOrders() {
        log.info("get list of orders");
        return orderRepository.findAll()
                .stream()
                .map(this::mapOrderToOrderDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getOrdersByUserLogin(String userLogin) {
        log.info("get orders by User login {}", userLogin);
        return orderRepository.findAllByUserLogin(userLogin)
                .stream()
                .map(this::mapOrderToOrderDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrderById(Long id) {
        log.info("getOrder by id {}", id);
        Order order = orderRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return mapOrderToOrderDTO(order);
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        log.info("create order of user {} from {} to {}",
                orderDTO.getUserDTO().getLogin(),
                orderDTO.getCityFrom(),
                orderDTO.getCityTo());
        Order order = mapOrderDTOtoOrder(orderDTO);
        order = orderRepository.save(order);
        return mapOrderToOrderDTO(order);
    }

    @Override
    public void deleteOrder(Long id) {
        log.info("deleteOrder with id {}", id);
        Order order = orderRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        orderRepository.delete(order);
    }

    private OrderDTO mapOrderToOrderDTO(Order order){
        return OrderDTO.builder()
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
                .id(0L)
                .cityFrom(orderDTO.getCityFrom())
                .cityTo(orderDTO.getCityTo())
                .parcelType(orderDTO.getParcelType())
                .user(userRepository.findByLogin(orderDTO.getUserDTO().getLogin()))
                .build();
    }
}
