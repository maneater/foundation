package com.maneater.foundation.controller;

import com.maneater.foundation.service.impl.IndexService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class IndexController {
    @Resource
    private IndexService indexService;

    @RequestMapping(value = "index")
    public String index(ModelMap modelMap) {
        return "/front/index";
    }
}
