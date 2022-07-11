package com.epam.spring.homework3.controller;

import com.epam.spring.homework3.controller.dto.DistanceDTO;
import com.epam.spring.homework3.controller.dto.OrderDTO;
import com.epam.spring.homework3.service.DeliveryService;
import com.epam.spring.homework3.service.model.Distance;
import com.epam.spring.homework3.service.model.Order;
import com.epam.spring.homework3.service.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Api(tags = "API description for SWAGGER documentation")
@ApiResponses({
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})
public class DeliveryController {
    private final DeliveryService deliveryService;

    @ApiOperation("Get distance by id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/distance/{id}")
    public DistanceDTO getDistance(@PathVariable int id) {
        return deliveryService.getDistance(id);
    }

    @ApiOperation("Get list of distances")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/distance")
    public List<DistanceDTO> getAllDistances(){
        return deliveryService.getAllDistances();
    }

    @ApiOperation("Create distance")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/distance")
    public DistanceDTO createDistance(@Valid @RequestBody DistanceDTO distanceDTO){
        return deliveryService.createDistance(distanceDTO);
    }

    @ApiOperation("Delete distance")
    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<Void> deleteDistance(@PathVariable int id){
        deliveryService.deleteDistance(id);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation("Get order by parameters")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/distance/{user}")
    public OrderDTO getOrder(@PathVariable User user, Distance distance, String parcelType){
        return deliveryService.getOrder(user, distance, parcelType);
    }

    @ApiOperation("Get list of orders")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/order")
    public List<OrderDTO> getAllOrders(){
        return deliveryService.getAllOrders();
    }

    @ApiOperation("Create order")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/order")
    public OrderDTO createOrder(@Valid OrderDTO orderDTO){
        return deliveryService.createOrder(orderDTO);
    }

    @ApiOperation("Delete order")
    @DeleteMapping(value = "/order/{user}")
    public ResponseEntity<Void> deleteOrder(Order order){
        deliveryService.deleteOrder(order);
        return ResponseEntity.noContent().build();
    }
}
