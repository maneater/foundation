package com.maneater.foundation.controller;

import com.maneater.foundation.entity.Admin;
import com.maneater.foundation.service.IAdminService;
import com.maneater.foundation.vo.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "admin")
public class AdminController {


    @Resource
    private IAdminService adminService;

    @RequestMapping("adminLogin")
    @ResponseBody
    public Result adminLogin(@RequestParam String name, @RequestParam String password) {
        Admin admin = adminService.login(name, password);
        if (admin != null) {
            return Result.result(1, "", null);
        } else {
            return Result.result(0, "用户名或密码错误", null);
        }
    }

    @RequestMapping("login")
    public String login() {
        return "/admin/login";
    }

    @RequestMapping("index")
    public String index() {
        return "/admin/index";
    }
}
