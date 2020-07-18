package com.example.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order_item")
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "order_id", nullable = false)
    private Integer orderId;

    @Column(name = "item_id", nullable = false)
    private Integer itemId;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id", insertable = false, updatable = false)
    private UserOrder userOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_id", insertable = false, updatable = false)
    private Item item;

    public OrderItem() {}

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

    public String toString() {
      return "OrderItem{id=" + id + 
        ", orderId=" + orderId + 
        ", itemId=" + itemId + 
        ", amount=" + amount + 
        "}";
    }

    public UserOrder getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(UserOrder userOrder) {
        this.userOrder = userOrder;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
