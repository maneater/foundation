package com.maneater.foundation.service.impl;

import com.maneater.foundation.Config;
import com.maneater.foundation.uitl.FileUtil;
import com.maneater.foundation.vo.FileInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by macbook on 15/11/20.
 */
@Service
public class UploadServices {


    public UploadServices() {
    }


    public List<FileInfo> listFiles(FileInfo parent, final FileInfo.FileType filterType) {
        String parentPath = null;
        File targetFile;
        if (parent != null && !StringUtils.isEmpty(parent.getFilePath())) {
            parentPath = parent.getFilePath();
            targetFile = new File(Config.FILE_UPLOAD_REAL_DIR_PATH, parent.getFilePath());
        } else {
            targetFile = new File(Config.FILE_UPLOAD_REAL_DIR_PATH);
        }
        if (targetFile.exists() && targetFile.isDirectory()) {
            File[] resultFiles;
            if (filterType == null) {
                resultFiles = targetFile.listFiles();
            } else {
                resultFiles = targetFile.listFiles(new FileFilter() {
                    @Override
                    public boolean accept(File pathname) {
                        return FileInfo.FileType.convert(pathname) == filterType;
                    }
                });
            }

            if (resultFiles != null) {
                List<FileInfo> fileInfoList = new ArrayList<FileInfo>();
                for (File file : resultFiles) {
                    fileInfoList.add(FileInfo.convert(parentPath, file));
                }
                return fileInfoList;
            }
        }
        return null;
    }


    public FileInfo uploadFile(FileInfo parentInfo, MultipartFile file) {
        File targetFile = null;
        FileOutputStream fileOutputStream = null;
        try {
            String fileName = file.getOriginalFilename();
            if (parentInfo != null && !StringUtils.isEmpty(parentInfo)) {
                targetFile = new File(Config.FILE_UPLOAD_REAL_DIR_PATH + "/" + parentInfo.getFilePath(), fileName);
            } else {
                targetFile = new File(Config.FILE_UPLOAD_REAL_DIR_PATH, fileName);
            }
            targetFile.createNewFile();
            fileOutputStream = new FileOutputStream(targetFile);
            if (FileUtil.copy(file.getInputStream(), fileOutputStream)) {
                return FileInfo.convert(parentInfo != null ? parentInfo.getFilePath() : null, targetFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
            targetFile.delete();
        } finally {
            FileUtil.closeSliently(fileOutputStream);
        }
        return null;
    }

    public boolean deleteFile(FileInfo fileInfo) {
        return new File(Config.FILE_UPLOAD_REAL_DIR_PATH, fileInfo.getFilePath()).delete();
    }

}
