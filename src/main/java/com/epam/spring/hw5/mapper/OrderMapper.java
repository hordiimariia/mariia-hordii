package com.epam.spring.hw5.mapper;

import com.epam.spring.hw5.dto.OrderDTO;
import com.epam.spring.hw5.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDTO mapOrderDTO(Order order);

    Order mapOrder(OrderDTO orderDTO);
}
