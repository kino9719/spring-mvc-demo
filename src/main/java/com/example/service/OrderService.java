package com.example.service;

import com.example.model.OrderItemInfo;
import com.example.model.UserOrder;
import com.example.repository.OrderItemRepository;
import com.example.repository.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    UserOrderRepository userOrderRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    public List<OrderItemInfo> getOrderItems(Integer orderId) {
        return userOrderRepository.findOrderItems(orderId);
    }

    public boolean isAccountOwnTheOrder(Integer accountId, Integer orderId) {
        Optional<UserOrder> userOrder = userOrderRepository.findById(orderId);

        return userOrder.get() != null && userOrder.get().getAccountId() == accountId;
    }

    @Transactional
    public void deleteOrder(Integer orderId) {
        orderItemRepository.deleteByOrderId(orderId);
        userOrderRepository.deleteById(orderId);
    }
}

