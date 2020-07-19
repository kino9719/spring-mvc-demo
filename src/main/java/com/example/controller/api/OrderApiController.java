package com.example.controller.api;

import com.example.model.OrderItemInfo;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class OrderApiController {
    @Autowired
    OrderService orderService;

    @GetMapping("/api/orders/{orderId}/items")
    public ResponseEntity<List<OrderItemInfo>> items(@PathVariable("orderId") Integer orderId, HttpSession httpSession) {
        Integer accountId = (Integer) httpSession.getAttribute("accountId");
        if (!((Boolean) httpSession.getAttribute("isAdmin")) && !orderService.isAccountOwnTheOrder(accountId, orderId)) {
            return new ResponseEntity(null, HttpStatus.FORBIDDEN);
        }

        return new ResponseEntity<List<OrderItemInfo>>(orderService.getOrderItems(orderId), HttpStatus.OK);
    }

    @DeleteMapping("/api/orders/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable("orderId") Integer orderId, HttpSession httpSession) {
        if (!((Boolean) httpSession.getAttribute("isAdmin"))) {
            return new ResponseEntity(null, HttpStatus.FORBIDDEN);
        }
        orderService.deleteOrder(orderId);

        return new ResponseEntity<String>("", HttpStatus.NO_CONTENT);
    }
}
