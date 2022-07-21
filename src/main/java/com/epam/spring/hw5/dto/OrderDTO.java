package com.epam.spring.hw5.dto;

import com.epam.spring.hw5.dto.group.OnCreate;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class OrderDTO {

    @NotBlank(message = "'cityFrom' shouldn't be empty", groups = OnCreate.class)
    private String cityFrom;

    @NotBlank(message = "'cityTo' shouldn't be empty", groups = OnCreate.class)
    private String cityTo;

    @NotBlank(message = "'parcelType' shouldn't be empty", groups = OnCreate.class)
    private String parcelType;

    @NotNull(message = "'UserDTO' shouldn't be absent in request", groups = OnCreate.class)
    private UserDTO userDTO;
}
