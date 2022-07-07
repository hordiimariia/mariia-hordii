package com.epam.spring.homework3.controller.dto;

import com.epam.spring.homework3.service.model.Distance;
import com.epam.spring.homework3.service.model.OrderStatus;
import com.epam.spring.homework3.service.model.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDTO {
    private int id;
    private User user;
    private Distance distance;
    private String parcelType;
    private double weight;
    private double length;
    private double width;
    private double height;
    private int deliveryTimeInDays;
    private double price;
    private OrderStatus status;
}
