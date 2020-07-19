package com.example.controller.page;

import com.example.model.OrderInfo;
import com.example.repository.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    UserOrderRepository userOrderRepository;

    @GetMapping("/")
    public String index(Model model, HttpSession httpSession) {
        if ((Boolean) httpSession.getAttribute("isAdmin") == true) {
            List<OrderInfo> orderInfos = userOrderRepository.listOrderInfos();
            model.addAttribute("orderInfos", orderInfos);
        } else {
            Integer accountId = (Integer) httpSession.getAttribute("accountId");
            List<OrderInfo> orderInfos = userOrderRepository.findOrderInfoByUsername(accountId);
            model.addAttribute("orderInfos", orderInfos);
        }

        return "order-list";
    }
}
