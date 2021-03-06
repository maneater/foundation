package com.maneater.foundation.controller;

import java.util.List;

import javax.annotation.Resource;

import com.maneater.foundation.nosql.entity.Product;
import com.maneater.foundation.nosql.entity.ProductCategory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maneater.foundation.Config;
import com.maneater.foundation.service.impl.ProductCategoryService;
import com.maneater.foundation.service.impl.ProductService;

@Controller
@RequestMapping("front/furniture")
public class FrontFurnitureController {

    private final static Logger logger = Logger
            .getLogger(FrontFurnitureController.class.getName());

    @Resource
    private ProductService productService;
    @Resource
    private ProductCategoryService productCategoryService;

    @RequestMapping({"", "index"})
    public String listFurnitures(String categoryId, Model model) {
        List<ProductCategory> categories = productCategoryService.listAll();
        List<Product> roomList = null;
        if (categoryId == null) {
        	if(categories != null && categories.size() > 0) {
        		categoryId = categories.get(0).getId();
        	}
        }
        roomList = productService.listByCategoryId(categoryId);

        model.addAttribute("categoryId", categoryId);
        model.addAttribute("categories", categories);
        model.addAttribute("itemList", roomList);

        return "/front/furniture/furniture";
    }

    @RequestMapping({"", "detail"})
    public String detail(String id, Model model) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "room");
        Product bean = productService.findById(id);
        if (bean == null) {
            return "";
        }
        String categoryId = bean.getCategoryId();
        String categoryName = bean.getCategoryName();
        List<ProductCategory> categories = productCategoryService.listAll();

        model.addAttribute("bean", bean);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("categoryName", categoryName);
        model.addAttribute("categories", categories);
        return "/front/furniture/furniture_detail";
    }
}
