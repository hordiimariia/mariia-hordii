package com.epam.spring.hw6.service;

import com.epam.spring.hw6.dto.OrderDTO;
import com.epam.spring.hw6.model.Order;
import com.epam.spring.hw6.model.User;
import com.epam.spring.hw6.repository.OrderRepository;
import com.epam.spring.hw6.repository.UserRepository;
import com.epam.spring.hw6.service.impl.OrderServiceImpl;
import com.epam.spring.hw6.test.util.TestDataUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.epam.spring.hw6.test.util.TestDataUtil.LOGIN;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class OrderServiceImplTest {
    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private UserRepository userRepository;

    @Test
    void listOrderTest(){
        List<Order> testOrderList = new ArrayList<>();

        Order testOrderFirst = TestDataUtil.createOrder();
        Order testOrderSecond = TestDataUtil.createOrder();
        Order testOrderThird = TestDataUtil.createOrder();

        OrderDTO testOrderDtoFirst = TestDataUtil.createOrderDTO();
        OrderDTO testOrderDtoSecond = TestDataUtil.createOrderDTO();
        OrderDTO testOrderDtoThird = TestDataUtil.createOrderDTO();

        testOrderList.add(testOrderFirst);
        testOrderList.add(testOrderSecond);
        testOrderList.add(testOrderThird);

        when(orderRepository.findAll()).thenReturn(testOrderList);

        List<OrderDTO> orderList = orderService.listOrders();

        assertThat(orderList, hasItems(testOrderDtoFirst, testOrderDtoSecond, testOrderDtoThird));
    }

    @Test
    void getOrderByUserLoginTest(){
        List<Order> testOrderList = new ArrayList<>();

        Order testOrderOne = TestDataUtil.createOrder();
        Order testOrderTwo = TestDataUtil.createOrder();

        testOrderList.add(testOrderOne);
        testOrderList.add(testOrderTwo);

        when(orderRepository.findAllByUserLogin(LOGIN)).thenReturn(testOrderList);

        List<OrderDTO> orderDTOList = orderService.getOrdersByUserLogin(LOGIN);

        OrderDTO testOrderDtoFirst = TestDataUtil.createOrderDTO();
        OrderDTO testOrderDtoSecond = TestDataUtil.createOrderDTO();
        OrderDTO testOrderDtoThird = TestDataUtil.createOrderDTO();

        assertThat(orderDTOList, hasItems(testOrderDtoFirst, testOrderDtoSecond, testOrderDtoThird));
    }

    @Test
    void getOrderByIdTest(){
        Order order = TestDataUtil.createOrder();
        when(orderRepository.findById(0L)).thenReturn(Optional.ofNullable(order));

        OrderDTO orderDTO = orderService.getOrderById(0L);

        assertThat(orderDTO, allOf(
                hasProperty("cityFrom", equalTo(order.getCityFrom())),
                hasProperty("parcelType", equalTo(order.getParcelType()))
        ));
    }

    @Test
    public void createOrderTest(){
        Order testOrder = TestDataUtil.createOrder();
        OrderDTO testOrderDTO = TestDataUtil.createOrderDTO();
        User testUser = TestDataUtil.createUser();

        when(orderRepository.save(any())).thenReturn(testOrder);
        when(userRepository.findByLogin(LOGIN)).thenReturn(testUser);

        OrderDTO orderDTO = orderService.createOrder(testOrderDTO);

        assertThat(orderDTO, allOf(
                hasProperty("cityFrom", equalTo(testOrderDTO.getCityFrom())),
                hasProperty("parcelType", equalTo(testOrderDTO.getParcelType()))
        ));
    }

    @Test
    public void deleteOrderTest(){
        Order testOrder = TestDataUtil.createOrder();

        when(orderRepository.findById(0L)).thenReturn(Optional.ofNullable(testOrder));

        orderService.deleteOrder(testOrder.getId());

        verify(orderRepository, times(1)).delete(testOrder);
    }
}
