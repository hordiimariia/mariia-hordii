package com.epam.spring.hw6;

import com.epam.spring.hw6.dto.OrderDTO;
import com.epam.spring.hw6.dto.UserDTO;
import com.epam.spring.hw6.test.util.TestDataUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Profile;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Profile("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {

    @Value("http://localhost:${local.server.port}/api/")
    private String baseUrl;

    @Value("${app.user.login}")
    private String login;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void getUserTest(){
        UserDTO userDTO = testRestTemplate.getForObject(baseUrl + "user/" + login, UserDTO.class);
        assertEquals(userDTO.getLogin(), login);
    }

}
