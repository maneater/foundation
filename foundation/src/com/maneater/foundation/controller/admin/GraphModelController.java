package com.maneater.foundation.controller.admin;

import com.maneater.foundation.Config;
import com.maneater.foundation.entity.GraphModel;
import com.maneater.foundation.entity.GraphModelCategory;
import com.maneater.foundation.entity.GraphRoom;
import com.maneater.foundation.entity.GraphRoomCategory;
import com.maneater.foundation.service.impl.GraphModelCategoryService;
import com.maneater.foundation.service.impl.GraphModelService;
import com.maneater.foundation.service.impl.GraphRoomCategoryService;
import com.maneater.foundation.service.impl.GraphRoomService;
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
public class GraphModelController {
    private final static Logger logger = Logger.getLogger(UserController.class.getName());

    @Resource
    private GraphModelService graphModelService;

    @Resource
    private GraphModelCategoryService graphModelCategoryService;

    @RequestMapping({"", "index"})
    public String listFurnitures(Model model) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "furniture");
        List<GraphModel> roomList = graphModelService.listAll();
        model.addAttribute("itemList", roomList);
        return "/admin/furniture";
    }

    @RequestMapping(value = {"show"}, method = RequestMethod.GET)
    public String showRoom(Model model, @RequestParam(required = false) Long id) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "furniture");
        List<GraphModelCategory> categoryList = graphModelCategoryService.listAll();
        GraphModel graphModel = graphModelService.findById(id);
        if (graphModel == null) {
            model.addAttribute("rs", Result.result(0, "can not find ", null));
        }
        model.addAttribute("isAdd", false);
        model.addAttribute("graphModel", graphModel);
        model.addAttribute("categoryList", categoryList);
        return "/admin/furniture_show";
    }

    @RequestMapping(value = {"add"}, method = RequestMethod.GET)
    public String addRoom(Model model) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "furniture");
        model.addAttribute("isAdd", true);
        model.addAttribute("categoryList", graphModelCategoryService.listAll());
        return "/admin/furniture_show";
    }

    @RequestMapping(value = {"enable"}, method = RequestMethod.POST)
    @ResponseBody
    public Result enableRoom(@RequestParam Long id, @RequestParam boolean enable) {
        boolean result = graphModelService.changeEnabel(id, enable);
        if (result) {
            return Result.result(1, "success", null);
        } else {
            return Result.result(0, "failed", null);
        }
    }

    @RequestMapping(value = {"save"}, method = RequestMethod.POST)
    @ResponseBody
    public Result saveRoom(@RequestBody GraphModel graphModel) {
        GraphModel localItem = null;

        GraphModelCategory category = graphModelCategoryService.findById(graphModel.getCategoryId());
        if (category == null) {
            return Result.result(0, "error category", null);
        }
        graphModel.setCategoryId(category.getId());
        graphModel.setCategoryName(category.getName());


        if (!StringUtils.isEmpty(graphModel.getId())) {//update
            localItem = graphModelService.findById(graphModel.getId());
            if (localItem == null) {
                return Result.result(0, "id:" + graphModel.getId() + " can not found!", null);
            }

            graphModel.setId(localItem.getId());
            graphModel.setCreateTime(localItem.getCreateTime());

            localItem = graphModelService.save(localItem);

        } else {//add
            localItem = graphModelService.save(graphModel);
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
        List<GraphModelCategory> roomList = graphModelCategoryService.listAll();
        model.addAttribute("itemList", roomList);
        return "/admin/furniture_catelist";
    }

    @RequestMapping(value = {"cateshow"}, method = RequestMethod.GET)
    public String showCategory(Model model, @RequestParam(required = false) Long id) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "furnitureCate");
        model.addAttribute("isAdd", false);
        GraphModelCategory graphRoomCategory = graphModelCategoryService.findById(id);
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
    public Result changeCategoryEnable(@RequestParam Long id, @RequestParam boolean enable) {
        boolean result = graphModelCategoryService.changeEnable(id, enable);
        if (result) {
            return Result.result(1, "success", null);
        } else {
            return Result.result(0, "failed", null);
        }
    }

    @RequestMapping(value = {"catesave"}, method = RequestMethod.POST)
    @ResponseBody
    public Result saveCategory(@RequestBody GraphModelCategory category) {
        GraphModelCategory localItem = null;
        if (!StringUtils.isEmpty(category.getId())) {//update
            localItem = graphModelCategoryService.findById(category.getId());
            if (localItem == null) {
                return Result.result(0, "id:" + category.getId() + " can not found!", null);
            }

            category.setId(localItem.getId());
            category.setCreateTime(localItem.getCreateTime());

            localItem = graphModelCategoryService.save(category);

        } else {//add
            localItem = graphModelCategoryService.save(category);
        }

        if (localItem != null) {
            return Result.result(1, "success", localItem);
        } else {
            return Result.result(0, "failed", null);
        }
    }


}
