package com.maneater.foundation.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maneater.foundation.service.IIndexService;

@Controller
public class IndexController {
    @Resource
    private IIndexService indexService;

    @RequestMapping(value = "index")
    public String index(ModelMap modelMap) {
        modelMap.put("isOpen", indexService.isSiteOpen());
        return "/index";
    }
}
