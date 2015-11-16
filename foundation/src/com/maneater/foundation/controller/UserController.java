package com.maneater.foundation.controller;

import com.maneater.foundation.entity.User;
import com.maneater.foundation.service.IUserService;
import com.maneater.foundation.uitl.SysUtil;
import com.maneater.foundation.vo.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2015/11/16 0016.
 */
@Controller("customerController")
@RequestMapping("user")
public class UserController {

    @Resource
    private IUserService userService;


    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(Model model, HttpServletRequest req, @RequestParam(required = false) String userName, @RequestParam(required = false) String password) {
        User user = userService.findByLoginAndPassword(userName, password);
        if (user != null) {
            SysUtil.userLogin(user, req);
            model.addAttribute("result", Result.result(1, "", null));
            return "redirect:/index";
        } else {
            model.addAttribute("result", Result.result(0, "用户名或密码错误", null));
            return "/login";
        }
    }


    @RequestMapping("logout")
    public String logout(HttpServletRequest req) {
        SysUtil.userLogout(req);
        return "redirect:/index";
    }


}
