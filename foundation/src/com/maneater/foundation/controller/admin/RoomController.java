package com.maneater.foundation.controller.admin;

import com.maneater.foundation.Config;
import com.maneater.foundation.entity.GraphRoom;
import com.maneater.foundation.entity.GraphRoomCategory;
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

/**
 * Created by Administrator on 2015/11/20 0020.
 */
@Controller
@RequestMapping("admin/room")
public class RoomController {
    private final static Logger logger = Logger.getLogger(UserController.class.getName());
    @Resource
    private GraphRoomService graphRoomService;
    @Resource
    private GraphRoomCategoryService graphRoomCategoryService;

    @RequestMapping({"", "index"})
    public String listRooms(Model model) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "room");
        List<GraphRoom> roomList = graphRoomService.lisAll();
        model.addAttribute("itemList", roomList);
        return "/admin/rooms";
    }

    @RequestMapping(value = {"show"}, method = RequestMethod.GET)
    public String showRoom(Model model, @RequestParam(required = false) Long id) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "room");
        List<GraphRoomCategory> categoryList = graphRoomCategoryService.listAll();
        GraphRoom graphRoom = graphRoomService.findById(id);
        if (graphRoom == null) {
            model.addAttribute("rs", Result.result(0, "can not find ", null));
        }
        model.addAttribute("isAdd", false);
        model.addAttribute("graphRoom", graphRoom);
        model.addAttribute("categoryList", categoryList);
        return "/admin/rooms_show";
    }

    @RequestMapping(value = {"add"}, method = RequestMethod.GET)
    public String addRoom(Model model) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "room");
        model.addAttribute("isAdd", true);
        model.addAttribute("categoryList", graphRoomCategoryService.listAll());
        return "/admin/rooms_show";
    }

    @RequestMapping(value = {"enable"}, method = RequestMethod.POST)
    @ResponseBody
    public Result enableRoom(@RequestParam Long id, @RequestParam boolean enable) {
        boolean result = graphRoomService.changeEnabel(id, enable);
        if (result) {
            return Result.result(1, "success", null);
        } else {
            return Result.result(0, "failed", null);
        }
    }

    @RequestMapping(value = {"save"}, method = RequestMethod.POST)
    @ResponseBody
    public Result saveRoom(@RequestBody GraphRoom graphRoom) {
        logger.info("saveRoom->" + graphRoom.toString());
        GraphRoom localItem = null;

        GraphRoomCategory graphRoomCategory = graphRoomCategoryService.findById(graphRoom.getCategoryId());
        if (graphRoomCategory == null) {
            return Result.result(0, "error category", null);
        }
        graphRoom.setCategoryId(graphRoomCategory.getId());
        graphRoom.setCategoryName(graphRoomCategory.getName());


        if (!StringUtils.isEmpty(graphRoom.getId())) {//update
            localItem = graphRoomService.findById(graphRoom.getId());
            if (localItem == null) {
                return Result.result(0, "id:" + graphRoom.getId() + " can not found!", null);
            }


            localItem.setCategoryId(graphRoom.getCategoryId());
            localItem.setCategoryName(graphRoom.getCategoryName());
            localItem.setInfo(graphRoom.getInfo());
            localItem.setModelPath(graphRoom.getModelPath());
            localItem.setPicUrl(graphRoom.getPicUrl());
            localItem.setEnable(graphRoom.isEnable());
            localItem = graphRoomService.save(localItem);

        } else {//add
            localItem = graphRoomService.save(graphRoom);
        }

        if (localItem != null) {
            return Result.result(1, "success", localItem);
        } else {
            return Result.result(0, "failed", null);
        }
    }

    /**
     * ********
     * room category
     * ************
     */


    @RequestMapping(value = {"cate"}, method = RequestMethod.GET)
    public String listCategorys(Model model) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "roomcate");
        List<GraphRoomCategory> roomList = graphRoomCategoryService.listAll();
        model.addAttribute("itemList", roomList);
        return "/admin/rooms_catelist";
    }

    @RequestMapping(value = {"cateshow"}, method = RequestMethod.GET)
    public String showCategory(Model model, @RequestParam(required = false) Long id) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "roomcate");
        model.addAttribute("isAdd", false);
        GraphRoomCategory graphRoomCategory = graphRoomCategoryService.findById(id);
        if (graphRoomCategory == null) {
            model.addAttribute("rs", Result.result(0, "can not find ", null));
        }
        model.addAttribute("item", graphRoomCategory);
        return "/admin/rooms_cateshow";
    }

    @RequestMapping(value = {"cateadd"}, method = RequestMethod.GET)
    public String addCategory(Model model) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "roomcate");
        model.addAttribute("isAdd", true);
        return "/admin/rooms_cateshow";
    }


    @RequestMapping(value = {"cateenable"}, method = RequestMethod.POST)
    @ResponseBody
    public Result changeCategoryEnable(@RequestParam Long id, @RequestParam boolean enable) {
        logger.info("changeCategoryEnable");
        boolean result = graphRoomCategoryService.changeEnable(id, enable);
        if (result) {
            return Result.result(1, "success", null);
        } else {
            return Result.result(0, "failed", null);
        }
    }

    @RequestMapping(value = {"catesave"}, method = RequestMethod.POST)
    @ResponseBody
    public Result saveCategory(@RequestBody GraphRoomCategory category) {
        logger.info("saveCategory->" + category.toString());
        GraphRoomCategory localItem = null;
        boolean success = false;
        if (!StringUtils.isEmpty(category.getId())) {//update
            localItem = graphRoomCategoryService.findById(category.getId());
            if (localItem == null) {
                return Result.result(0, "id:" + category.getId() + " can not found!", null);
            }
            //copy field
            localItem.setName(category.getName());
            localItem.setInfo(category.getInfo());
            localItem.setPicUrl(category.getPicUrl());
            localItem.setEnable(category.isEnable());
            localItem = graphRoomCategoryService.save(localItem);

        } else {//add
            localItem = graphRoomCategoryService.save(category);
        }

        if (localItem != null) {
            return Result.result(1, "success", localItem);
        } else {
            return Result.result(0, "failed", null);
        }
    }


}
