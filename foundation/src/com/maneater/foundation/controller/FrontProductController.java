package com.maneater.foundation.controller;


import com.maneater.foundation.nosql.entity.*;
import com.maneater.foundation.service.impl.*;
import com.maneater.foundation.uitl.SysUtil;
import com.maneater.foundation.vo.AddInfo;
import com.maneater.foundation.vo.OrderForm;
import com.maneater.foundation.vo.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("front/product")
public class FrontProductController {

    @Resource
    private ProductService productService;
    @Resource
    private ProductCategoryService productCategoryService;

    @Resource
    private RoomCategoryService roomCategoryService;

    @Resource
    private RoomService roomService;

    @RequestMapping({"room"})
    //展示房间list
    public String listRooms(Model model, @RequestParam(required = false) String categoryId) {
        List<Room> roomList = null;
        List<RoomCategory> roomCategoryList = roomCategoryService.listAllByEnable(true);
        if (categoryId != null) {
            roomList = roomService.listByCategoryId(categoryId);
        } else {
            roomList = roomService.listAllByEnable(true);
        }

        model.addAttribute("roomList", roomList);
        model.addAttribute("roomCategoryList", roomCategoryList);
        model.addAttribute("categoryId", categoryId);
        return "/front/room";
    }

    @RequestMapping({"product"})
    //展示产品list
    public String listProduct(Model model, @RequestParam(required = false) String categoryId) {
        List<Product> productList = null;
        List<ProductCategory> productCategoryList = productCategoryService.listAllByEnable(true);
        if (!StringUtils.isEmpty(categoryId)) {
            productList = productService.listByCategoryId(categoryId);
        } else {
            productList = productService.listAllByEnable(true);
        }

        model.addAttribute("productList", productList);
        model.addAttribute("productCategoryList", productCategoryList);
        model.addAttribute("productCategoryId", categoryId);
        return "/front/product";
    }

    //添加产品
    @ResponseBody
    @RequestMapping("productAdd")
    public Result addProduct(HttpServletRequest req, @RequestParam() String productCode, @RequestParam() int qty) {
        String userId = SysUtil.getLoginUserId(req);
        Product product = productService.findByCode(productCode);
        if (product == null) {
            return Result.result(0, "no such product code", null);
        }
        orderService.addProduct(userId, productCode, qty);
        return Result.result(1, "success", null);
    }

    //批量添加产品
    @ResponseBody
    @RequestMapping("productBatchAdd")
    public Result addProduct(HttpServletRequest req, @RequestBody() AddInfo[] addInfos) {
        String userId = SysUtil.getLoginUserId(req);
        return orderService.addProduct(userId, addInfos);
    }


    @Resource
    private OrderService orderService = null;

    //订单汇总
    @RequestMapping("order")
    public String order(HttpServletRequest req, Model model) {
        OrderInfo orderInfo = orderService.loadOrderItemData(orderService.getNoCommitOrder(SysUtil.getLoginUserId(req)));
        model.addAttribute("order", orderInfo);
        return "/front/done/summary";
    }

    //订单提交
    //TODO 准备位置展示数据
    @RequestMapping("orderSubmit")
    public String orderSubmit(HttpServletRequest req, Model model, String orderId, OrderForm orderForm, String name, String designation, String company, String companyAddress, String deliveryAddress, String contactNumber, String email) {
        Result result = orderService.submitOrder(SysUtil.getLoginUserId(req), orderId, orderForm.getAddInfoList(), name, designation, company, companyAddress, deliveryAddress, contactNumber, email);
        model.addAttribute("result", result);
        return "/front/done/ordersuccess";
    }

}
