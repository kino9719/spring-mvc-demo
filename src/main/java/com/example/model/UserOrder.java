package com.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Table(name = "user_order")
@Entity
public class UserOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "account_id", nullable = false)
    private Integer accountId;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "created_time", nullable = false)
    private Integer createdTime;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="userOrder")
    private Set<OrderItem> orderItems;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="account_id", insertable = false, updatable = false)
    private Account account;

    public UserOrder() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Integer createdTime) {
        this.createdTime = createdTime;
    }

    public String toString() {
      return "UserOrder{id=" + id +
        ", accountId=" + accountId + 
        ", phone=" + phone + 
        ", address=" + address + 
        ", createdTime=" + createdTime + 
        "}";
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
