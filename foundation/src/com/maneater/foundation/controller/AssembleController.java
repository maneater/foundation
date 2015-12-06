//package com.maneater.foundation.controller;
//
//import com.maneater.foundation.Config;
//import com.maneater.foundation.entity.Room;
//import com.maneater.foundation.service.impl.*;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.annotation.Resource;
//import java.util.Arrays;
//
///**
// * Created by Administrator on 2015/11/18 0018.
// * Demo
// */
//@Controller()
//@RequestMapping(value = "step")
//public class AssembleController {
//
//    @Resource
//    private GraphRoomService graphRoomService;
//
//    @Resource
//    private GraphRoomCategoryService graphRoomCategoryService;
//
//    @Resource
//    private GraphModelService graphModelService;
//
//    @Resource
//    private GraphModelCategoryService graphModelCategoryService;
//
//    //show room category
//    @RequestMapping(value = "step1", method = RequestMethod.GET)
//    public String listRoomCategory(Model model) {
////        model.addAttribute("supplierList", supplierService.listAllSupplierByEnable(true));
//        model.addAttribute("roomCategoryList", graphRoomCategoryService.listAllByEnable(true));
////        model.addAttribute("rooList", graphRoomService.listAllByEnable(true));
//        return "/front/step1";
//    }
//
//    // show root list
//    @RequestMapping(value = "step2", method = RequestMethod.GET)
//    public String listRoomByCategory(Model model, @RequestParam long roomCategoryId) {
//        model.addAttribute("rooList", graphRoomService.listByCategoryId(roomCategoryId));
//        return "/front/step2";
//    }
//
//    //show furniture \ catelog \ supplier
//    @RequestMapping(value = "step3", method = RequestMethod.GET)
//    public String listFurnitureAndCategory(Model model, @RequestParam long roomId) {
//        model.addAttribute("furinitureCategoryList", graphModelCategoryService.listAll());
//        model.addAttribute("furinitureSupplierList", graphSupplierService.listAll());
//        model.addAttribute("roomId", roomId);
//        model.addAttribute("furinitureList", graphModelService.listAll());
//        return "/front/step3";
//    }
//
//
//    // show
//    @RequestMapping(value = "step4", method = RequestMethod.POST)
//    public String prepareAppletZipProperties(Model model, @RequestParam Long[] modelIds, @RequestParam(required = false) Long roomId) {
//        System.out.println(Arrays.toString(modelIds));
//        String zipProPath = graphSupplierService.createAppletZip(Config.REAL_PATH, modelIds);
//        model.addAttribute("propertiesPath", zipProPath);
//        if (roomId != null) {
//            Room room = graphRoomService.findById(roomId);
//            if (room != null) {
//                model.addAttribute("sh3dFilePath", room.getModelPath());
//            }
//        }
//        return "/front/3d/step3";
//    }
//}
