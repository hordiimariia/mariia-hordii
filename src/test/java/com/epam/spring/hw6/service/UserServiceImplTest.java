package com.epam.spring.hw6.service;

import com.epam.spring.hw6.dto.UserDTO;
import com.epam.spring.hw6.model.User;
import com.epam.spring.hw6.repository.UserRepository;
import com.epam.spring.hw6.service.impl.UserServiceImpl;
import com.epam.spring.hw6.test.util.TestDataUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static com.epam.spring.hw6.test.util.TestDataUtil.LOGIN;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Test
    void listUserTest(){
        List<User> testUserList = new ArrayList<>();

        User testUserFirst = TestDataUtil.createUser();
        User testUserSecond = TestDataUtil.createUser();
        User testUserThird = TestDataUtil.createUser();

        UserDTO testUserDtoFirst = TestDataUtil.createUserDTO();
        UserDTO testUserDtoSecond = TestDataUtil.createUserDTO();
        UserDTO testUserDtoThird = TestDataUtil.createUserDTO();

        testUserList.add(testUserFirst);
        testUserList.add(testUserSecond);
        testUserList.add(testUserThird);

        when(userRepository.findAll()).thenReturn(testUserList);

        List<UserDTO> userList = userService.listUsers();

        assertThat(userList, hasItems(testUserDtoFirst, testUserDtoSecond, testUserDtoThird));
    }

    @Test
    void getUserTest(){
        User user = TestDataUtil.createUser();
        when(userRepository.findByLogin(LOGIN)).thenReturn(user);

        UserDTO userDTO = userService.getUser(LOGIN);
        assertThat(userDTO, allOf(
                hasProperty("login", equalTo(user.getLogin())),
                hasProperty("firstName", equalTo(user.getFirstName()))
        ));
    }

    @Test
    void getNullPointerExceptionTest(){
        when(userRepository.findByLogin(LOGIN)).thenReturn(null);
        assertThrows(NullPointerException.class, () -> userService.getUser(LOGIN));
    }

    @Test
    public void createUserTest(){
        User testUser = TestDataUtil.createUser();
        UserDTO testUserDTO = TestDataUtil.createUserDTO();

        when(userRepository.save(any())).thenReturn(testUser);

        UserDTO userDTO = userService.createUser(testUserDTO);

        assertThat(userDTO, allOf(
                hasProperty("firstName", equalTo(testUserDTO.getFirstName())),
                hasProperty("lastName", equalTo(testUserDTO.getLastName())),
                hasProperty("login", equalTo(testUserDTO.getLogin()))
        ));
    }

    @Test
    public void updateUserTest(){
        User testUser = TestDataUtil.createUser();
        UserDTO testUserDTO = TestDataUtil.createUserDTO();

        when(userRepository.findByLogin(testUserDTO.getLogin())).thenReturn(testUser);
        when(userRepository.save(any())).thenReturn(testUser);

        UserDTO userDTO = userService.updateUser(testUser.getLogin(), testUserDTO);

        assertThat(userDTO, allOf(
                hasProperty("firstName", equalTo(testUserDTO.getFirstName())),
                hasProperty("lastName", equalTo(testUserDTO.getLastName())),
                hasProperty("login", equalTo(testUserDTO.getLogin()))
        ));
    }

    @Test
    public void deleteUserTest(){
        User testUser = TestDataUtil.createUser();

        when(userRepository.findByLogin(LOGIN)).thenReturn(testUser);

        userService.deleteUser(testUser.getLogin());

        verify(userRepository, times(1)).delete(testUser);
    }
}
