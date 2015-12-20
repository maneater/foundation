package com.maneater.foundation.controller;

import com.maneater.foundation.Config;
import com.maneater.foundation.nosql.entity.Room;
import com.maneater.foundation.nosql.entity.RoomCategory;
import com.maneater.foundation.service.impl.OrderService;
import com.maneater.foundation.service.impl.RoomCategoryService;
import com.maneater.foundation.service.impl.RoomService;
import com.maneater.foundation.uitl.SysUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("front/room")
public class FrontRoomController {
    private final static Logger logger = Logger
            .getLogger(FrontRoomController.class.getName());
    @Resource
    private RoomService roomService;
    @Resource
    private RoomCategoryService roomCategoryService;

    @RequestMapping({"", "index"})
    public String listRooms(String categoryId, Model model) {
        List<Room> roomList = null;
        String title = null;
        if (categoryId == null) {
            roomList = roomService.lisAll();
            title = "Rooms";
            model.addAttribute("categoryId", null);
        } else {
            roomList = roomService.listByCategoryId(categoryId);
            RoomCategory category = roomCategoryService.findById(categoryId);
            title = category.getName();
            model.addAttribute("categoryId", categoryId);
        }

        List<RoomCategory> categories = roomCategoryService.listAllByEnable(true);
        model.addAttribute("title", title);
        model.addAttribute("categories", categories);
        model.addAttribute("itemList", roomList);
        return "/front/room/rooms";
    }

    @RequestMapping({"", "detail"})
    public String detail(String id, Model model) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "room");
        Room bean = roomService.findById(id);
        if (bean == null) {
            return "";
        }
        String categoryId = bean.getCategoryId();
        List<RoomCategory> categories = roomCategoryService.listAllByEnable(true);

        model.addAttribute("bean", bean);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("categories", categories);
        return "/front/room/room_detail";
    }

    private OrderService orderService = null;

    @RequestMapping("confirm")
    public String confirmRoom(HttpServletRequest req, Model model, String roomId, int roomNum) {
        model.addAttribute("result", orderService.confirmRoom(SysUtil.getLoginUserId(req), roomId, roomNum));
        return "redirect:/front/furniture/index";
    }
}
