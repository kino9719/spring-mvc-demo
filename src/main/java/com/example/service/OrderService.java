package com.example.service;

import com.example.model.OrderItemInfo;
import com.example.repository.OrderItemRepository;
import com.example.repository.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    UserOrderRepository userOrderRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    public List<OrderItemInfo> getOrderItems(Integer orderId) {
        return userOrderRepository.findOrderItems(orderId);
    }

    @Transactional
    public void deleteOrder(Integer orderId) {
        orderItemRepository.deleteByOrderId(orderId);
        userOrderRepository.deleteById(orderId);
    }
}

