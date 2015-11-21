package com.maneater.foundation.controller.admin;

import com.maneater.foundation.service.impl.UploadServices;
import com.maneater.foundation.vo.FileInfo;
import com.maneater.foundation.vo.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2015/11/20 0020.
 */
@Controller
@RequestMapping("admin/upload")
public class UploadController {

    @Resource
    private UploadServices uploadServices;


    @RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
    public String listFiles(Model model, @ModelAttribute FileInfo parentInfo, @RequestParam FileInfo.FileType fileType) {
        model.addAttribute("itemList", uploadServices.listFiles(parentInfo, fileType));
        model.addAttribute("parentInfo", parentInfo);
        return "/admin/upload";
    }

    @ResponseBody
    @RequestMapping(value = {"indexApi"}, method = RequestMethod.GET)
    public Result listFilesApi(@ModelAttribute FileInfo parentInfo, @RequestParam FileInfo.FileType fileType) {
        return Result.result(1, "", uploadServices.listFiles(parentInfo, fileType));
    }


    @RequestMapping(value = "image", method = RequestMethod.POST)
    @ResponseBody
    public Result uploadPicture(@ModelAttribute FileInfo parentInfo, @RequestParam("file") MultipartFile file) {
        uploadServices.uploadFile(parentInfo, file);
        return null;
    }

}
