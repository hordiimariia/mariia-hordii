package com.epam.spring.hw5.controller;

import com.epam.spring.hw5.dto.OrderDTO;
import com.epam.spring.hw5.dto.group.OnCreate;
import com.epam.spring.hw5.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Delivery Controller")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class DeliveryController {
    private final OrderService orderService;

    @ApiOperation("Get list of Orders")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/orders")
    public List<OrderDTO> listOrders() {
        return orderService.listOrders();
    }

    @ApiOperation("Get User Orders by login")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/orders/{userLogin}")
    public List<OrderDTO> getOrdersByUserLogin(@PathVariable String userLogin){
        return orderService.getOrdersByUserLogin(userLogin);
    }

    @ApiOperation("Get Order by id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/order/{id}")
    public OrderDTO getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

    @ApiOperation("Create new order")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/order")
    public OrderDTO createOrder(@RequestBody @Validated(OnCreate.class) OrderDTO orderDTO){
        return orderService.createOrder(orderDTO);
    }

    @ApiOperation("Delete Order by id")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/order/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
