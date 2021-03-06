package com.maneater.foundation.controller.admin;

import com.maneater.foundation.Config;
import com.maneater.foundation.nosql.entity.User;
import com.maneater.foundation.service.impl.UserService;
import com.maneater.foundation.uitl.PageUtil;
import com.maneater.foundation.vo.Result;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2015/11/9 0009.
 */
@Controller
@RequestMapping("admin/users")
public class UserController {
    private final static Logger logger = Logger.getLogger(UserController.class.getName());

    @Resource
    private UserService userService = null;


    @RequestMapping("index")
    public String index(Model model, @RequestParam(defaultValue = "1") int tagetPage, @RequestParam(defaultValue = Config.PAGE_SIZE) int pageSize) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "users");
//        Page<User> userPage = userService.list(tagetPage - 1, pageSize);
//        model.addAttribute("userPage", userPage);
//        model.addAttribute("userList", userPage.getContent());
//
//        PageUtil pageUtil = new PageUtil();
//        pageUtil.setTotalSize(userPage.getTotalElements());
//        pageUtil.setCurPage(userPage.getNumber() + 1);
//        pageUtil.setPageSize(pageSize);
//        pageUtil.setUrlFormat("?pageSize={pageSize}&tagetPage={pageNum}&{otherParams}");
//        model.addAttribute("pagePagination", pageUtil.getHtml());
        model.addAttribute("userList", userService.list());
        return "/admin/users";
    }

    @RequestMapping(value = {"enable"}, method = RequestMethod.POST)
    @ResponseBody
    public Result enable(@RequestParam String id, @RequestParam boolean enable) {
        boolean result = userService.changeEnable(id, enable);
        if (result) {
            return Result.result(1, "success", null);
        } else {
            return Result.result(0, "failed", null);
        }
    }

    @RequestMapping("show")
    public String show(Model model, @RequestParam(required = true) String id) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "users");
        User user = userService.findUser(id);
        model.addAttribute("item", user);
        return "/admin/users_show";
    }

    @RequestMapping("update")
    @ResponseBody
    public Result update(@RequestBody User user) {
        logger.info("update->" + user.toString());
        if (StringUtils.isEmpty(user.getId())) {
            return Result.result(0, "user id:" + user.getId() + " can not found!", null);
        }
        User localUser = userService.findUser(user.getId());
        if (localUser == null) {
            return Result.result(0, "user id:" + user.getId() + " can not found!", null);
        }

        //copy
        localUser.setInfo(user.getInfo());
        localUser.setHeadPicUrl(user.getHeadPicUrl());
        localUser.setEnable(user.isEnable());

        boolean success = userService.save(localUser);
        return Result.result(1, "success", null);
    }

}
