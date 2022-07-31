package com.epam.spring.hw6.dto;

import com.epam.spring.hw6.dto.group.OnCreate;
import com.epam.spring.hw6.dto.group.OnUpdate;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    @NotBlank(message = "'firstName' shouldn't be empty", groups = OnCreate.class)
    private String firstName;

    @NotBlank(message = "'lastName' shouldn't be empty", groups = OnCreate.class)
    private String lastName;

    @NotBlank(message = "'login' shouldn't be empty", groups = {OnCreate.class, OnUpdate.class})
    private String login;

    @NotBlank(message = "'password' shouldn't be empty", groups = OnCreate.class)
    private String password;

    @NotBlank(message = "'repeatPassword shouldn't be empty", groups = OnCreate.class)
    private String repeatPassword;
}
