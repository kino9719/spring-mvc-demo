package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderInfo {
    @Id
    private Integer id;

    private Integer accountId;

    private String phone;

    private String address;

    private Integer createdTime;

    private String accountName;

    private Long total;

    public OrderInfo() {}

    public OrderInfo(Integer id, Integer accountId, String phone, String address, Integer createdTime, String accountName, Long total) {
        this.id = id;
        this.accountId = accountId;
        this.phone = phone;
        this.address = address;
        this.createdTime = createdTime;
        this.accountName = accountName;
        this.total = total;
    }

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

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String account_name) {
        this.accountName = account_name;
    }
}
