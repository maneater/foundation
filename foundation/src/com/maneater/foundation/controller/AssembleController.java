package com.maneater.foundation.controller;

import com.maneater.foundation.service.impl.SupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * Created by Administrator on 2015/11/18 0018.
 */
@Controller()
@RequestMapping(value = "step")
public class AssembleController {
    @Resource
    private SupplierService supplierService;

    @RequestMapping(value = "step1", method = RequestMethod.GET)
    public String listSupplier(Model model) {
        model.addAttribute("itemList", supplierService.listAllSupplier());
        return "/step1";
    }

    @RequestMapping(value = "step2", method = RequestMethod.GET)
    public String listModelBySupplier(Model model, @RequestParam long supplierId) {
        model.addAttribute("itemList", supplierService.listGraphModelBySupplier(supplierId));
        return "/step2";
    }

    @RequestMapping(value = "step3", method = RequestMethod.POST)
    public String prepareAppletZipProperties(HttpSession session, Model model, @RequestParam Long[] modelIds) {
        String realPath = session.getServletContext().getRealPath("/");
        System.out.println(Arrays.toString(modelIds));
        String zipProPath = supplierService.createAppletZip(realPath, modelIds);
        model.addAttribute("propertiesPath", zipProPath);
        return "/step3";
    }
}
