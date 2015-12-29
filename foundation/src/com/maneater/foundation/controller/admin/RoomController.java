package com.maneater.foundation.controller.admin;

import com.maneater.foundation.Config;
import com.maneater.foundation.nosql.entity.ProductCategory;
import com.maneater.foundation.nosql.entity.ProductCategoryPosition;
import com.maneater.foundation.nosql.entity.Room;
import com.maneater.foundation.nosql.entity.RoomCategory;
import com.maneater.foundation.service.impl.ProductCategoryService;
import com.maneater.foundation.service.impl.RoomCategoryService;
import com.maneater.foundation.service.impl.RoomService;
import com.maneater.foundation.vo.Result;
import com.maneater.foundation.vo.ViewPosition;
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
    private RoomService roomService;
    @Resource
    private RoomCategoryService roomCategoryService;
    @Resource
    private ProductCategoryService productCategoryService;

    @RequestMapping({"", "index"})
    public String listRooms(Model model) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "room");
        List<Room> roomList = roomService.lisAll();
        model.addAttribute("itemList", roomList);
        return "/admin/rooms";
    }

    @RequestMapping(value = {"show"}, method = RequestMethod.GET)
    public String showRoom(Model model, @RequestParam(required = false) String id) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "room");
        List<RoomCategory> categoryList = roomCategoryService.listAll();
        Room room = roomService.findById(id);
        if (room == null) {
            model.addAttribute("rs", Result.result(0, "can not find ", null));
        }
        model.addAttribute("isAdd", false);
        model.addAttribute("graphRoom", room);
        model.addAttribute("categoryList", categoryList);
        return "/admin/rooms_show";
    }

    /**
     * 2015年12月28日新增
     *
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = {"view_edit"}, method = RequestMethod.GET)
    public String viewEdit(Model model, @RequestParam(required = false) String id) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "room");
        List<RoomCategory> categoryList = roomCategoryService.listAll();
        Room room = roomService.findById(id);
        if (room == null) {
            model.addAttribute("rs", Result.result(0, "can not find ", null));
        }

        // 获得家具类型，只获取有效的
        List<ProductCategory> productCategories = productCategoryService.listAllByEnable(true);

        model.addAttribute("isAdd", false);
        model.addAttribute("graphRoom", room);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("productCategories", productCategories);
        model.addAttribute("productCategories", productCategories);

        //已经保存的位置信息，包含 x,y,z,已经家具分类对象
        List<ProductCategoryPosition> positionList = roomService.findPositionListByRoomId(id);
        model.addAttribute("positionList", positionList);

        return "/admin/rooms_view_edit";
    }

    //更新坐标,需要前台构造成json，指定roomId，指定位置列表
    @RequestMapping(value = {"saveview"}, method = RequestMethod.POST)
    @ResponseBody
    public Result saveRoomView(@RequestBody ViewPosition viewPosition) {
        logger.info("saveRoomView->" + viewPosition);
        return roomService.saveRoomPositions(viewPosition);
    }


    @RequestMapping(value = {"add"}, method = RequestMethod.GET)
    public String addRoom(Model model) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "room");
        model.addAttribute("isAdd", true);
        model.addAttribute("categoryList", roomCategoryService.listAll());
        return "/admin/rooms_show";
    }

    @RequestMapping(value = {"enable"}, method = RequestMethod.POST)
    @ResponseBody
    public Result enableRoom(@RequestParam String id, @RequestParam boolean enable) {
        boolean result = roomService.changeEnable(id, enable);
        if (result) {
            return Result.result(1, "success", null);
        } else {
            return Result.result(0, "failed", null);
        }
    }

    @RequestMapping(value = {"save"}, method = RequestMethod.POST)
    @ResponseBody
    public Result saveRoom(@RequestBody Room room) {
        logger.info("saveRoom->" + room.toString());
        Room localItem = null;

        RoomCategory roomCategory = roomCategoryService.findById(room.getCategoryId());
        if (roomCategory == null) {
            return Result.result(0, "error category", null);
        }
        room.setCategoryId(roomCategory.getId());
        room.setCategoryName(roomCategory.getName());


        if (!StringUtils.isEmpty(room.getId())) {//update
            localItem = roomService.findById(room.getId());
            if (localItem == null) {
                return Result.result(0, "id:" + room.getId() + " can not found!", null);
            }
            room.setCreateTime(localItem.getCreateTime());

            localItem = roomService.save(room);

        } else {//add
            localItem = roomService.save(room);
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
        List<RoomCategory> roomList = roomCategoryService.listAll();
        model.addAttribute("itemList", roomList);
        return "/admin/rooms_catelist";
    }

    @RequestMapping(value = {"cateshow"}, method = RequestMethod.GET)
    public String showCategory(Model model, @RequestParam(required = false) String id) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "roomcate");
        model.addAttribute("isAdd", false);
        RoomCategory roomCategory = roomCategoryService.findById(id);
        if (roomCategory == null) {
            model.addAttribute("rs", Result.result(0, "can not find ", null));
        }
        model.addAttribute("item", roomCategory);
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
    public Result changeCategoryEnable(@RequestParam String id, @RequestParam boolean enable) {
        logger.info("changeCategoryEnable");
        boolean result = roomCategoryService.changeEnable(id, enable);
        if (result) {
            return Result.result(1, "success", null);
        } else {
            return Result.result(0, "failed", null);
        }
    }

    @RequestMapping(value = {"catesave"}, method = RequestMethod.POST)
    @ResponseBody
    public Result saveCategory(@RequestBody RoomCategory category) {
        logger.info("saveCategory->" + category.toString());
        RoomCategory localItem = null;
        boolean success = false;
        if (!StringUtils.isEmpty(category.getId())) {//update
            localItem = roomCategoryService.findById(category.getId());
            if (localItem == null) {
                return Result.result(0, "id:" + category.getId() + " can not found!", null);
            }
            category.setCreateTime(localItem.getCreateTime());

            localItem = roomCategoryService.save(category);

        } else {//add
            localItem = roomCategoryService.save(category);
        }

        if (localItem != null) {
            return Result.result(1, "success", localItem);
        } else {
            return Result.result(0, "failed", null);
        }
    }


}
