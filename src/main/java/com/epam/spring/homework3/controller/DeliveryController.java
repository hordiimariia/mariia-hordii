package com.epam.spring.homework3.controller;

import com.epam.spring.homework3.controller.dto.DistanceDTO;
import com.epam.spring.homework3.controller.dto.OrderDTO;
import com.epam.spring.homework3.service.DeliveryService;
import com.epam.spring.homework3.service.model.Distance;
import com.epam.spring.homework3.service.model.Order;
import com.epam.spring.homework3.service.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DeliveryController {
    private final DeliveryService deliveryService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/distance/{id}")
    public DistanceDTO getDistance(@PathVariable int id) {
        return deliveryService.getDistance(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/distance")
    public List<DistanceDTO> getAllDistances(){
        return deliveryService.getAllDistances();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/distance")
    public DistanceDTO createDistance(@RequestBody DistanceDTO distanceDTO){
        return deliveryService.createDistance(distanceDTO);
    }

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<Void> deleteDistance(@PathVariable int id){
        deliveryService.deleteDistance(id);
        return ResponseEntity.noContent().build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/distance/{user}")
    public OrderDTO getOrder(@PathVariable User user, Distance distance, String parcelType){
        return deliveryService.getOrder(user, distance, parcelType);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/order")
    public List<OrderDTO> getAllOrders(){
        return deliveryService.getAllOrders();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/order")
    public OrderDTO createOrder(OrderDTO orderDTO){
        return deliveryService.createOrder(orderDTO);
    }

    @DeleteMapping(value = "/order/{user}")
    public ResponseEntity<Void> deleteOrder(Order order){
        deliveryService.deleteOrder(order);
        return ResponseEntity.noContent().build();
    }
}
