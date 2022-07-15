package com.epam.spring.hw3.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDTO {
    private String orderId;
    private String cityFrom;
    private String cityTo;
    private String parcelType;
    private UserDTO userDTO;
}
