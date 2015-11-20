package com.maneater.foundation.controller.admin;

import com.maneater.foundation.vo.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Administrator on 2015/11/20 0020.
 */
@Controller
@RequestMapping("upload")
public class UploadController {


    @RequestMapping(value = "img", method = RequestMethod.POST)
    @ResponseBody
    public Result uploadPicture(@RequestParam("file") MultipartFile file) {
//        file.getInputStream();
        return null;
    }

}
