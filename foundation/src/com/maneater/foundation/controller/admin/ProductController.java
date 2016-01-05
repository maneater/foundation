package com.maneater.foundation.controller.admin;

import com.maneater.foundation.Config;
import com.maneater.foundation.nosql.entity.Product;
import com.maneater.foundation.nosql.entity.ProductCategory;
import com.maneater.foundation.service.impl.*;
import com.maneater.foundation.vo.Result;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("admin/furniture")
public class ProductController {
    private final static Logger logger = Logger.getLogger(UserController.class.getName());

    @Resource
    private ProductService productService;

    @Resource
    private ProductCategoryService productCategoryService;

    @RequestMapping({"", "index"})
    public String listFurnitures(Model model) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "furniture");
        List<Product> roomList = productService.listAll();
        model.addAttribute("itemList", roomList);
        model.addAttribute("categoryList", productCategoryService.listAll());
        return "/admin/furniture";
    }

    @RequestMapping(value = {"show"}, method = RequestMethod.GET)
    public String show(Model model, @RequestParam(required = false) String id, @RequestParam(required = false) String code) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "furniture");
        Product product = null;
        if (!StringUtils.isEmpty(id)) {
            product = productService.findById(id);
        } else if (!StringUtils.isEmpty(code)) {
            product = productService.findByCode(code);
        }

        if (product == null) {
            model.addAttribute("rs", Result.result(0, "can not find ", null));
        } else {
            model.addAttribute("category", productCategoryService.findById(product.getCategoryId()));
        }

        model.addAttribute("isAdd", false);
        model.addAttribute("graphModel", product);
        return "/admin/furniture_show";
    }

    @RequestMapping(value = {"add"}, method = RequestMethod.GET)
    public String add(Model model, @RequestParam(required = true) String cateId) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "furniture");
        model.addAttribute("isAdd", true);
        model.addAttribute("category", productCategoryService.findById(cateId));
        return "/admin/furniture_show";
    }

    @RequestMapping(value = {"enable"}, method = RequestMethod.POST)
    @ResponseBody
    public Result enable(@RequestParam String id, @RequestParam boolean enable) {
        boolean result = productService.changeEnable(id, enable);
        if (result) {
            return Result.result(1, "success", null);
        } else {
            return Result.result(0, "failed", null);
        }
    }

    @RequestMapping(value = {"save"}, method = RequestMethod.POST)
    @ResponseBody
    public Result save(@ModelAttribute Product product) {
        Product localItem = null;

        ProductCategory category = productCategoryService.findById(product.getCategoryId());
        if (category == null) {
            return Result.result(0, "error category", null);
        }


        product.setCategoryId(category.getId());
        product.setCategoryName(category.getName());

        if (!StringUtils.isEmpty(product.getId())) {//update
            localItem = productService.findById(product.getId());
            if (localItem == null) {
                return Result.result(0, "id:" + product.getId() + " can not found!", null);
            }

            product.setId(localItem.getId());
            product.setCreateTime(localItem.getCreateTime());

            localItem = productService.save(product);

        } else {//add
            localItem = productService.save(product);
        }

        if (localItem != null) {
            return Result.result(1, "success", localItem);
        } else {
            return Result.result(0, "failed", null);
        }
    }

    /**
     * ********
     * category
     * ************
     */


    @RequestMapping(value = {"cate"}, method = RequestMethod.GET)
    public String listCategorys(Model model) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "furnitureCate");
        List<ProductCategory> roomList = productCategoryService.listAll();
        model.addAttribute("itemList", roomList);
        return "/admin/furniture_catelist";
    }

    @RequestMapping(value = {"cateshow"}, method = RequestMethod.GET)
    public String showCategory(Model model, @RequestParam(required = false) String id) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "furnitureCate");
        model.addAttribute("isAdd", false);
        ProductCategory graphRoomCategory = productCategoryService.findById(id);
        if (graphRoomCategory == null) {
            model.addAttribute("rs", Result.result(0, "can not find ", null));
        }
        model.addAttribute("item", graphRoomCategory);
        return "/admin/furniture_cateshow";
    }

    @RequestMapping(value = {"cateadd"}, method = RequestMethod.GET)
    public String addCategory(Model model) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "furnitureCate");
        model.addAttribute("isAdd", true);
        return "/admin/furniture_cateshow";
    }


    @RequestMapping(value = {"cateenable"}, method = RequestMethod.POST)
    @ResponseBody
    public Result changeCategoryEnable(@RequestParam String id, @RequestParam boolean enable) {
        boolean result = productCategoryService.changeEnable(id, enable);
        if (result) {
            return Result.result(1, "success", null);
        } else {
            return Result.result(0, "failed", null);
        }
    }

    @RequestMapping(value = {"catesave"}, method = RequestMethod.POST)
    @ResponseBody
    public Result saveCategory(@ModelAttribute ProductCategory category) {
        ProductCategory localItem = null;
        if (!StringUtils.isEmpty(category.getId())) {//update
            localItem = productCategoryService.findById(category.getId());
            if (localItem == null) {
                return Result.result(0, "id:" + category.getId() + " can not found!", null);
            }

            category.setId(localItem.getId());
            category.setCreateTime(localItem.getCreateTime());

            localItem = productCategoryService.save(category);

        } else {//add
            localItem = productCategoryService.save(category);
        }

        if (localItem != null) {
            return Result.result(1, "success", localItem);
        } else {
            return Result.result(0, "failed", null);
        }
    }


}
