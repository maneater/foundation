package com.maneater.foundation.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maneater.foundation.Config;
import com.maneater.foundation.entity.GraphModel;
import com.maneater.foundation.entity.GraphModelCategory;
import com.maneater.foundation.service.impl.GraphModelCategoryService;
import com.maneater.foundation.service.impl.GraphModelService;

@Controller
@RequestMapping("front/furniture")
public class FrontFurnitureController {
	
	private final static Logger logger = Logger
	.getLogger(FrontFurnitureController.class.getName());

    @Resource
    private GraphModelService graphModelService;
    @Resource
    private GraphModelCategoryService graphModelCategoryService;
	
    @RequestMapping({"", "index"})
    public String listFurnitures(Long categoryId, Model model) {
        List<GraphModel> roomList = null;
        if(categoryId == null || categoryId < 1) {
        	roomList = graphModelService.listAll();
        	model.addAttribute("categoryId", -1);
        } else {
        	roomList = graphModelService.listByCategoryId(categoryId);
        	model.addAttribute("categoryId", categoryId);
        }
        
        List<GraphModelCategory> categories = graphModelCategoryService.listAll();
        model.addAttribute("categories", categories);
        model.addAttribute("itemList", roomList);
        
        return "/front/furniture/furniture";
    }
    
    @RequestMapping({"", "detail"})
    public String detail(Long id, Model model) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "room");
        GraphModel bean = graphModelService.findById(id);
        if(bean == null) {
        	return "";
        }
        Long categoryId = bean.getCategoryId();
        List<GraphModelCategory> categories = graphModelCategoryService.listAll();

        model.addAttribute("bean", bean);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("categories", categories);
        return "/front/furniture/detail";
    }
}
