package com.epam.spring.hw4.controller;

import com.epam.spring.hw4.dto.UserDTO;
import com.epam.spring.hw4.dto.group.OnCreate;
import com.epam.spring.hw4.dto.group.OnUpdate;
import com.epam.spring.hw4.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "User Controller")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @ApiOperation("Get list of Users")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/users")
    public List<UserDTO> listUsers(){
        return userService.listUsers();
    }

    @ApiOperation("Get User by login")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/user/{login}")
    public UserDTO getUser(@PathVariable String login){
        return userService.getUser(login);
    }

    @ApiOperation("Create new User")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/user")
    public UserDTO createUser (@RequestBody @Validated(OnCreate.class) UserDTO userDTO){
        return userService.createUser(userDTO);
    }

    @ApiOperation("Update User login")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/user/{oldLogin}")
    public UserDTO updateUser(@PathVariable @Validated(OnUpdate.class) String oldLogin, @RequestBody UserDTO userDTO){
        return userService.updateUser(oldLogin, userDTO);
    }

    @ApiOperation("Delete User by login")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/user/{login}")
    public ResponseEntity<Void> deleteUser(@PathVariable String login){
        userService.deleteUser(login);
        return ResponseEntity.noContent().build();
    }

}
