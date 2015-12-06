package com.maneater.foundation.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maneater.foundation.Config;
import com.maneater.foundation.entity.Room;
import com.maneater.foundation.entity.RoomCategory;
import com.maneater.foundation.service.impl.RoomCategoryService;
import com.maneater.foundation.service.impl.RoomService;

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
    public String listRooms(Long categoryId, Model model) {
        List<Room> roomList = null;
        String title = null;
        if(categoryId == null || categoryId < 1) {
        	roomList = roomService.lisAll();
        	title = "Rooms";
        	model.addAttribute("categoryId", -1);
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
    public String detail(Long id, Model model) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "room");
        Room bean = roomService.findById(id);
        if(bean == null) {
        	return "";
        }
        Long categoryId = bean.getCategoryId();
        List<RoomCategory> categories = roomCategoryService.listAllByEnable(true);

        model.addAttribute("bean", bean);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("categories", categories);
        return "/front/room/room_detail";
    }
}
