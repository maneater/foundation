package com.maneater.foundation.controller.admin;

import com.maneater.foundation.Config;
import com.maneater.foundation.entity.ExpandProperty;
import com.maneater.foundation.service.impl.ExpandPropertyService;
import com.maneater.foundation.vo.Result;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("admin/property")
public class PropertyController {
    private final static Logger logger = Logger.getLogger(PropertyController.class.getName());

    @Resource
    private ExpandPropertyService expandPropertyService;

    @RequestMapping({"", "index"})
    public String listAll(Model model) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "property");
        List<ExpandProperty> itemList = expandPropertyService.listAll();
        model.addAttribute("itemList", itemList);
        return "/admin/property";
    }

    //
    @RequestMapping(value = {"show"}, method = RequestMethod.GET)
    public String show(Model model, @RequestParam(required = false) Long id) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "property");
        ExpandProperty item = expandPropertyService.findById(id);
        if (item == null) {
            model.addAttribute("rs", Result.result(0, "can not find ", null));
        }
        model.addAttribute("isAdd", false);
        model.addAttribute("item", item);
        return "/admin/property_show";
    }

    @RequestMapping(value = {"add"}, method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "property");
        model.addAttribute("isAdd", true);
        return "/admin/property_show";
    }

    @RequestMapping(value = {"enable"}, method = RequestMethod.POST)
    @ResponseBody
    public Result enable(@RequestParam Long id, @RequestParam boolean enable) {
        boolean result = expandPropertyService.changeEnabel(id, enable);
        if (result) {
            return Result.result(1, "success", null);
        } else {
            return Result.result(0, "failed", null);
        }
    }

    //
    @RequestMapping(value = {"save"}, method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestBody ExpandProperty expandProperty) {
        ExpandProperty localItem = null;

        if (!StringUtils.isEmpty(expandProperty.getId())) {//update
            localItem = expandPropertyService.findById(expandProperty.getId());
            if (localItem == null) {
                return Result.result(0, "id:" + expandProperty.getId() + " can not found!", null);
            }

            expandProperty.setId(localItem.getId());
            expandProperty.setCreateTime(localItem.getCreateTime());

            localItem = expandPropertyService.save(expandProperty);

        } else {//add
            localItem = expandPropertyService.save(expandProperty);
        }

        if (localItem != null) {
            return Result.result(1, "success", localItem);
        } else {
            return Result.result(0, "failed", null);
        }
    }
//
//    /**
//     * ********
//     * category
//     * ************
//     */
//
//
//    @RequestMapping(value = {"cate"}, method = RequestMethod.GET)
//    public String listCategorys(Model model) {
//        model.addAttribute(Config.ADMIN_ACT_NAME, "furnitureCate");
//        List<ProductCategory> roomList = productCategoryService.listAll();
//        model.addAttribute("itemList", roomList);
//        return "/admin/furniture_catelist";
//    }
//
//    @RequestMapping(value = {"cateshow"}, method = RequestMethod.GET)
//    public String showCategory(Model model, @RequestParam(required = false) Long id) {
//        model.addAttribute(Config.ADMIN_ACT_NAME, "furnitureCate");
//        model.addAttribute("isAdd", false);
//        ProductCategory graphRoomCategory = productCategoryService.findById(id);
//        if (graphRoomCategory == null) {
//            model.addAttribute("rs", Result.result(0, "can not find ", null));
//        }
//        model.addAttribute("item", graphRoomCategory);
//        return "/admin/furniture_cateshow";
//    }
//
//    @RequestMapping(value = {"cateadd"}, method = RequestMethod.GET)
//    public String addCategory(Model model) {
//        model.addAttribute(Config.ADMIN_ACT_NAME, "furnitureCate");
//        model.addAttribute("isAdd", true);
//        return "/admin/furniture_cateshow";
//    }
//
//
//    @RequestMapping(value = {"cateenable"}, method = RequestMethod.POST)
//    @ResponseBody
//    public Result changeCategoryEnable(@RequestParam Long id, @RequestParam boolean enable) {
//        boolean result = productCategoryService.changeEnable(id, enable);
//        if (result) {
//            return Result.result(1, "success", null);
//        } else {
//            return Result.result(0, "failed", null);
//        }
//    }
//
//    @RequestMapping(value = {"catesave"}, method = RequestMethod.POST)
//    @ResponseBody
//    public Result saveCategory(@RequestBody ProductCategory category) {
//        ProductCategory localItem = null;
//        if (!StringUtils.isEmpty(category.getId())) {//update
//            localItem = productCategoryService.findById(category.getId());
//            if (localItem == null) {
//                return Result.result(0, "id:" + category.getId() + " can not found!", null);
//            }
//
//            category.setId(localItem.getId());
//            category.setCreateTime(localItem.getCreateTime());
//
//            localItem = productCategoryService.save(category);
//
//        } else {//add
//            localItem = productCategoryService.save(category);
//        }
//
//        if (localItem != null) {
//            return Result.result(1, "success", localItem);
//        } else {
//            return Result.result(0, "failed", null);
//        }
//    }


}
