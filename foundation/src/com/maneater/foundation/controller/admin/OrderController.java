package com.maneater.foundation.controller.admin;

import com.maneater.foundation.Config;
import com.maneater.foundation.nosql.entity.OrderInfo;
import com.maneater.foundation.service.impl.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "admin/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @RequestMapping({"", "index"})
    public String list(Model model) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "order");
        List<OrderInfo> orderInfoList = orderService.listAll();
        model.addAttribute("orderList", orderService.attachUserInfo(orderInfoList));
        return "/admin/orders";
    }

    @RequestMapping("show")
    public String show(Model model, String orderId) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "order");
        model.addAttribute("order", orderService.attachUserInfo(orderService.getDetailById(orderId)));
        return "/admin/orderdetail";
    }

}
