package com.maneater.foundation.controller.admin;

import com.maneater.foundation.Config;
import com.maneater.foundation.entity.GraphSupplier;
import com.maneater.foundation.service.impl.GraphSupplierService;
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
@RequestMapping("admin/supplier")
public class GraphSupplierController {
    private final static Logger logger = Logger.getLogger(GraphSupplierController.class.getName());
    @Resource
    private GraphSupplierService graphSupplierService;

    private final static String ACT = "supplier";

    @RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute(Config.ADMIN_ACT_NAME, ACT);
        List<GraphSupplier> supplierList = graphSupplierService.listAll();
        model.addAttribute("itemList", supplierList);
        return "/admin/supplier";
    }

    @RequestMapping(value = {"show"}, method = RequestMethod.GET)
    public String show(Model model, @RequestParam(required = false) Long id) {
        model.addAttribute(Config.ADMIN_ACT_NAME, ACT);
        model.addAttribute("isAdd", false);
        GraphSupplier supplier = graphSupplierService.findById(id);
        if (supplier == null) {
            model.addAttribute("rs", Result.result(0, "can not find ", null));
        }
        model.addAttribute("item", supplier);
        return "/admin/supplier_show";
    }

    @RequestMapping(value = {"add"}, method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(Config.ADMIN_ACT_NAME, ACT);
        model.addAttribute("isAdd", true);
        return "/admin/supplier_show";
    }


    @RequestMapping(value = {"enable"}, method = RequestMethod.POST)
    @ResponseBody
    public Result changeEnable(@RequestParam Long id, @RequestParam boolean enable) {
        boolean result = graphSupplierService.changeEnable(id, enable);
        if (result) {
            return Result.result(1, "success", null);
        } else {
            return Result.result(0, "failed", null);
        }
    }

    @RequestMapping(value = {"save"}, method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestBody GraphSupplier supplier) {
        GraphSupplier localItem = null;
        boolean success = false;
        if (!StringUtils.isEmpty(supplier.getId())) {//update
            localItem = graphSupplierService.findById(supplier.getId());
            if (localItem == null) {
                return Result.result(0, "id:" + supplier.getId() + " can not found!", null);
            }
            supplier.setCreateTime(localItem.getCreateTime());
            localItem = graphSupplierService.save(supplier);
        } else {//add
            localItem = graphSupplierService.save(supplier);
        }

        if (localItem != null) {
            return Result.result(1, "success", localItem);
        } else {
            return Result.result(0, "failed", null);
        }
    }


}
