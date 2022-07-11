package com.epam.spring.homework3.controller.dto;

import com.epam.spring.homework3.service.model.UserRole;
import com.epam.spring.homework3.service.model.UserStatus;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
@Builder
public class UserDTO {
    private int id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String login;
    @Email
    private String email;
    @NotNull
    private String city;
    @PositiveOrZero
    private double money;
    @NotNull
    private UserRole role;
    @NotNull
    private UserStatus status;
}
