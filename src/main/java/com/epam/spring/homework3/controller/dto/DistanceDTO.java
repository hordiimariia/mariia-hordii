package com.epam.spring.homework3.controller.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Builder
public class DistanceDTO {
    private int id;
    @NotNull
    private String from;
    @NotNull
    private String to;
    @Positive 
    private int distance;
}
