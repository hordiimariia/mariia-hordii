package com.epam.spring.homework3.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DistanceDTO {
    private int id;
    private String from;
    private String to;
    private int distance;
}
