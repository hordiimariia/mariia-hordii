package com.epam.spring.hw3.controller;

import com.epam.spring.hw3.dto.OrderDTO;
import com.epam.spring.hw3.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DeliveryController {
    private final OrderService orderService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/orders")
    public List<OrderDTO> listOrders() {
        return orderService.listOrders();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/orders/{userLogin}")
    public List<OrderDTO> getOrdersByUserLogin(@PathVariable String userLogin){
        return orderService.getOrdersByUserLogin(userLogin);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/order/{orderId}")
    public OrderDTO getOrderById(@PathVariable String orderId){
        return orderService.getOrderById(orderId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/order")
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO){
        return orderService.createOrder(orderDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/order/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable String orderId){
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }
}
