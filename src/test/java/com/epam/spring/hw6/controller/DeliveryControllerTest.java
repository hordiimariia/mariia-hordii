package com.epam.spring.hw6.controller;

import com.epam.spring.hw6.dto.OrderDTO;
import com.epam.spring.hw6.service.OrderService;
import com.epam.spring.hw6.test.config.TestConfig;
import com.epam.spring.hw6.test.util.TestDataUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static com.epam.spring.hw6.test.util.TestDataUtil.ID;
import static com.epam.spring.hw6.test.util.TestDataUtil.LOGIN;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DeliveryController.class)
@AutoConfigureMockMvc
@Import(TestConfig.class)
public class DeliveryControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    OrderService orderService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void listOrdersTest() throws Exception {
        OrderDTO orderDTO = TestDataUtil.createOrderDTO();

        when(orderService.listOrders()).thenReturn(Collections.singletonList(orderDTO));

        mockMvc
                .perform(get("/api/orders"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].cityFrom").value(orderDTO.getCityFrom()));
    }

    @Test
    void getOrdersByUserLoginTest() throws Exception {
        OrderDTO orderDTO = TestDataUtil.createOrderDTO();

        when(orderService.getOrdersByUserLogin(LOGIN)).thenReturn(Collections.singletonList(orderDTO));

        mockMvc
                .perform(get("/api/orders/" + LOGIN))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].cityFrom").value(orderDTO.getCityFrom()));
    }

    @Test
    void getOrderByIdTest() throws Exception {
        OrderDTO orderDTO = TestDataUtil.createOrderDTO();

        when(orderService.getOrderById(ID)).thenReturn(orderDTO);

        mockMvc
                .perform(get("/api/order/" + ID))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.cityFrom").value(orderDTO.getCityFrom()));
    }

    @Test
    void createOrderTest() throws Exception {
        OrderDTO orderDTO = TestDataUtil.createOrderDTO();

        when(orderService.createOrder(orderDTO)).thenReturn(orderDTO);

        mockMvc
                .perform(post("/api/order")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(orderDTO)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.cityFrom").value(orderDTO.getCityFrom()));

        verify(orderService, times(1)).createOrder(orderDTO);
    }

    @Test
    void deleteOrderTest() throws Exception {
        doNothing().when(orderService).deleteOrder(ID);

        mockMvc
                .perform(delete("/api/order/" + ID))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}
