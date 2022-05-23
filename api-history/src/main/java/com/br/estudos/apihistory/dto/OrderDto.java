package com.br.estudos.apihistory.dto;

public class OrderDto {
    private Long id;
    private Integer orderNumber;
    private String storeName;

    public OrderDto(Long id, Integer orderNumber, String storeName) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.storeName = storeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
