package com.br.estudos.apihistory.entity;

import javax.persistence.*;

@Table(name = "orders")
@Entity()
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "order_number")
    private Integer orderNumber;
    @Column(name = "store_name")
    private String storeName;

    public OrderEntity() {
    }

    public OrderEntity(Integer orderNumber, String storeName) {
        this.orderNumber = orderNumber;
        this.storeName = storeName;
    }

    public Long getId() {
        return id;
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
