package com.maneater.foundation.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maneater.foundation.Config;
import com.maneater.foundation.entity.GraphRoom;
import com.maneater.foundation.entity.GraphRoomCategory;
import com.maneater.foundation.service.impl.GraphRoomCategoryService;
import com.maneater.foundation.service.impl.GraphRoomService;

@Controller
@RequestMapping("front/room")
public class FrontRoomController {
	private final static Logger logger = Logger
			.getLogger(FrontRoomController.class.getName());
	@Resource
	private GraphRoomService graphRoomService;
	@Resource
    private GraphRoomCategoryService graphRoomCategoryService;

    @RequestMapping({"", "index"})
    public String listRooms(Long categoryId, Model model) {
        List<GraphRoom> roomList = null;
        String title = null;
        if(categoryId == null || categoryId < 1) {
        	roomList = graphRoomService.lisAll();
        	title = "Rooms";
        	model.addAttribute("categoryId", -1);
        } else {
        	roomList = graphRoomService.listByCategoryId(categoryId);
        	GraphRoomCategory category = graphRoomCategoryService.findById(categoryId);
        	title = category.getName();
        	model.addAttribute("categoryId", categoryId);
        }
        
        List<GraphRoomCategory> categories = graphRoomCategoryService.listAllByEnable(true);
        model.addAttribute("title", title);
        model.addAttribute("categories", categories);
        model.addAttribute("itemList", roomList);
        return "/front/room/rooms";
    }
    
    @RequestMapping({"", "detail"})
    public String detail(Long id, Model model) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "room");
        GraphRoom bean = graphRoomService.findById(id);
        if(bean == null) {
        	return "";
        }
        Long categoryId = bean.getCategoryId();
        List<GraphRoomCategory> categories = graphRoomCategoryService.listAllByEnable(true);

        model.addAttribute("bean", bean);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("categories", categories);
        return "/front/room/room_detail";
    }
}
