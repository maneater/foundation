package com.maneater.foundation.controller.admin;

import com.maneater.foundation.Config;
import com.maneater.foundation.entity.Admin;
import com.maneater.foundation.service.IAdminService;
import com.maneater.foundation.uitl.SysUtil;
import com.maneater.foundation.vo.Result;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "admin")
public class AdminController {
    private final static Logger logger = Logger.getLogger(AdminController.class.getName());

    @Resource
    private IAdminService adminService;

    @RequestMapping("adminLogin")
    @ResponseBody
    public Result adminLogin(HttpServletRequest req, @RequestParam String name, @RequestParam String password) {
        logger.info("requestLogin:" + name + password);
        Admin admin = adminService.findByNameAndPass(name, password);
        if (admin != null) {
            SysUtil.adminLogin(req, admin);
            return Result.result(1, "", null);
        } else {
            return Result.result(0, "用户名或密码错误", null);
        }
    }

    @RequestMapping("login")
    public String login() {
        return "/admin/login";
    }

    @RequestMapping({"index", ""})
    public String index(Model model) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "index");
        return "/admin/index";
    }
}
