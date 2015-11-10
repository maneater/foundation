package com.maneater.foundation.controller;

import com.maneater.foundation.Config;
import com.maneater.foundation.entity.User;
import com.maneater.foundation.service.IUserService;
import com.maneater.foundation.uitl.PageUtil;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2015/11/9 0009.
 */
@Controller
@RequestMapping("admin/users")
public class UserController {
    @Resource
    private IUserService userService = null;

    @RequestMapping("index")
    public String index(Model model, @RequestParam(defaultValue = "1") int tagetPage, @RequestParam(defaultValue = Config.PAGE_SIZE) int pageSize) {
        model.addAttribute(Config.ADMIN_ACT_NAME, "users");
        Page<User> userPage = userService.list(tagetPage - 1, pageSize);
        model.addAttribute("userPage", userPage);
        model.addAttribute("userList", userPage.getContent());

        PageUtil pageUtil = new PageUtil();
        pageUtil.setTotalSize(userPage.getTotalElements());
        pageUtil.setCurPage(userPage.getNumber() + 1);
        pageUtil.setPageSize(pageSize);
        pageUtil.setUrlFormat("?pageSize={pageSize}&tagetPage={pageNum}&{otherParams}");
        model.addAttribute("pagePagination", pageUtil.getHtml());

        return "/admin/users";
    }

}
