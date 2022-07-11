package com.epam.spring.homework3.controller.dto;

import com.epam.spring.homework3.service.model.Distance;
import com.epam.spring.homework3.service.model.OrderStatus;
import com.epam.spring.homework3.service.model.User;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Builder
public class OrderDTO {

    private int id;

    @NotBlank
    @NotNull
    private User user;

    @NotNull
    private Distance distance;
    private String parcelType;

    @Positive
    private double weight;
    @Positive
    private double length;
    @Positive
    private double width;
    @Positive
    private double height;
    @Positive
    private int deliveryTimeInDays;
    private double price;
    @NotNull
    private OrderStatus status;
}
