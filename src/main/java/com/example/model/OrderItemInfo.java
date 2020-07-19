package com.example.model;

import javax.persistence.*;

@Entity
public class OrderItemInfo {
    @Id
    private Integer id;

    private Integer orderId;

    private Integer itemId;

    private Integer amount;

    private Integer price;

    private String name;

    public OrderItemInfo() {}

    public OrderItemInfo(Integer id, Integer orderId, Integer itemId, Integer amount, Integer price, String name) {
        this.id = id;
        this.orderId = orderId;
        this.itemId = itemId;
        this.amount = amount;
        this.price = price;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
