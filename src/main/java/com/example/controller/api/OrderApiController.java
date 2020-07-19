package com.example.controller.api;

import com.example.model.OrderItemInfo;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderApiController {
    @Autowired
    OrderService orderService;

    @GetMapping("/api/order/{orderId}/items")
    public List<OrderItemInfo> items(@PathVariable("orderId") Integer orderId) {
        return orderService.getOrderItems(orderId);
    }
}
