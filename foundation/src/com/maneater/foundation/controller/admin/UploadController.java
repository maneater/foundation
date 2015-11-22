package com.maneater.foundation.controller.admin;

import com.maneater.foundation.service.impl.UploadServices;
import com.maneater.foundation.vo.FileInfo;
import com.maneater.foundation.vo.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;

/**
 * Created by Administrator on 2015/11/20 0020.
 */
@Controller
@RequestMapping("admin/upload")
public class UploadController {

    @Resource
    private UploadServices uploadServices;


    @RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
    public String listFiles(Model model, @ModelAttribute FileInfo parentInfo, @RequestParam(required = false) FileInfo.FileType fileType) {
        model.addAttribute("itemList", uploadServices.listFiles(parentInfo, fileType));
        model.addAttribute("parentInfo", parentInfo);
        model.addAttribute("fileType", fileType);
        return "/admin/upload";
    }

    @ResponseBody
    @RequestMapping(value = {"indexApi"}, method = RequestMethod.GET)
    public Result listFilesApi(@ModelAttribute FileInfo parentInfo, @RequestParam(required = false) FileInfo.FileType fileType) {
        return Result.result(1, "", uploadServices.listFiles(parentInfo, fileType));
    }

    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public Result deleteUpload(@ModelAttribute FileInfo fileInfo) {
        boolean result = uploadServices.deleteFile(fileInfo);
        return result ? Result.result(1, "success", null) : Result.result(0, "failed", null);
    }


    @RequestMapping(value = "upload", method = RequestMethod.POST)
    @ResponseBody
    public Result uploadPicture(@ModelAttribute FileInfo parentInfo, @RequestParam("file") MultipartFile file) {
        FileInfo fileInfo = uploadServices.uploadFile(parentInfo, file);
        if (fileInfo != null) {
            return Result.result(1, "success", fileInfo);
        } else {
            return Result.result(0, "error", fileInfo);
        }
    }

}
