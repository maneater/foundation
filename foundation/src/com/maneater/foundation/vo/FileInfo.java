package com.maneater.foundation.vo;

import org.springframework.util.StringUtils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class FileInfo {
    private String fileName;
    private String filePath;
    private boolean isDir;
    private long size;
    private FileType fileType = FileType.unknown;

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getFilePathEncode() {
        try {
            return URLEncoder.encode(this.filePath, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public boolean isDir() {
        return isDir;
    }

    public void setDir(boolean isDir) {
        this.isDir = isDir;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public enum FileType {
        img, zip, txt, unknown, folder, sh3d;

        public static FileType convert(File file) {
            String fileNameUpper = file.getName().toUpperCase();
            FileType fileType = FileType.unknown;
            if (fileNameUpper.endsWith(".JPG") || fileNameUpper.endsWith(".JPEG") || fileNameUpper.endsWith(".PNG") || fileNameUpper.endsWith(".BMP")) {
                fileType = FileType.img;
            } else if (fileNameUpper.endsWith(".ZIP") || fileNameUpper.endsWith(".JAR")) {
                fileType = FileType.zip;
            } else if (fileNameUpper.endsWith(".TXT")) {
                fileType = FileType.txt;
            } else if (file.isDirectory()) {
                fileType = FileType.folder;
            } else if (fileNameUpper.endsWith(".SH3D")) {
                fileType = FileType.sh3d;
            }
            return fileType;
        }
    }

    public boolean isImg() {
        return FileType.img == this.fileType;
    }

    public boolean isZip() {
        return FileType.zip == this.fileType;
    }

    public boolean isSh3d() {
        return FileType.sh3d == this.fileType;
    }

    public static FileInfo convert(String parentPath, File file) {
        FileInfo fileInfo = new FileInfo();
        fileInfo.setFileName(file.getName());
        fileInfo.setDir(file.isDirectory());
        fileInfo.setFilePath(StringUtils.isEmpty(parentPath) ? file.getName() : (parentPath + "/" + file.getName()));
        fileInfo.setSize(file.length());
        FileType fileType = FileType.convert(file);
        fileInfo.setFileType(fileType);
        return fileInfo;
    }

}
