package com.example.service;

import com.example.model.OrderItemInfo;
import com.example.repository.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    UserOrderRepository userOrderRepository;

    public List<OrderItemInfo> getOrderItems(Integer orderId) {
        return userOrderRepository.findOrderItems(orderId);
    }
}

