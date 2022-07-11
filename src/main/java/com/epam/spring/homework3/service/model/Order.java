package com.epam.spring.homework3.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
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
