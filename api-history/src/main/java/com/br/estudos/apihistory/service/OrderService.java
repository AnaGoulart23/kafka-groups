package com.br.estudos.apihistory.service;

import com.br.estudos.apihistory.dto.OrderDto;
import com.br.estudos.apihistory.dto.OrderResponse;
import com.br.estudos.apihistory.entity.OrderEntity;
import com.br.estudos.apihistory.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderResponse getAll() {
        return mapperToResponse(orderRepository.findAll());
    }

    private OrderResponse mapperToResponse(List<OrderEntity> all) {
        Integer size = all.size();
        List<OrderDto> orders = new ArrayList<>();
        all.forEach(order -> orders.add(new OrderDto(order.getId(), order.getOrderNumber(), order.getStoreName())));
        return new OrderResponse(size, orders);
    }
}
