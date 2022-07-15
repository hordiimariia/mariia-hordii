package com.epam.spring.hw3.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
    private String orderId;
    private String cityFrom;
    private String cityTo;
    private String parcelType;
    private User user;
}
