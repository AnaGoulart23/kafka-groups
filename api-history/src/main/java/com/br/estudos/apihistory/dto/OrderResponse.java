package com.br.estudos.apihistory.dto;

import java.util.List;

public class OrderResponse {
    private Integer qtt;
    private List<OrderDto> orders;

    public OrderResponse(Integer qtt, List<OrderDto> orders) {
        this.qtt = qtt;
        this.orders = orders;
    }

    public Integer getQtt() {
        return qtt;
    }

    public void setQtt(Integer qtt) {
        this.qtt = qtt;
    }

    public List<OrderDto> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDto> orders) {
        this.orders = orders;
    }
}
