package com.maneater.foundation.uitl;

import com.maneater.foundation.entity.GraphModel;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileUtil {


    public static boolean zipStringToFile(String content, String contentName, String zipOutFilePath) {
        try {
            System.out.println(zipOutFilePath);
            OutputStream outputStream = new FileOutputStream(zipOutFilePath);
            ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
            ZipEntry zipEntry = new ZipEntry(contentName);
            zipOutputStream.putNextEntry(zipEntry);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(content.getBytes("utf-8"));
            int byteRead;
            while ((byteRead = byteArrayInputStream.read()) != -1) {
                zipOutputStream.write(byteRead);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.flush();
            zipOutputStream.close();
            byteArrayInputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(zipStringToFile("name=1\r\n#asdfa其它文字\r\n\n\n\n\nend", "PluginFurnitureCatalog.properties", "/", "default.zip"));
    }

    public static String string2MD5(String srcName) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            char[] charArray = srcName.toCharArray();
            byte[] byteArray = new byte[charArray.length];

            for (int i = 0; i < charArray.length; i++)
                byteArray[i] = (byte) charArray[i];
            byte[] md5Bytes = md5.digest(byteArray);
            StringBuffer hexValue = new StringBuffer();
            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16)
                    hexValue.append("0");
                hexValue.append(Integer.toHexString(val));
            }
            return hexValue.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return srcName;
        }
    }

    public static boolean copy(InputStream inputStream, OutputStream outPutStream) throws IOException {

        byte[] data = new byte[10240];
        int dataSize = 0;

        try {
            while ((dataSize = inputStream.read(data)) != -1) {
                outPutStream.write(data, 0, dataSize);
            }
        } finally {
            close(inputStream);
            close(outPutStream);
        }
        return true;
    }

    public static boolean copy(InputStream inputStream, FileChannel outChannel) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byte[] data = new byte[1024];
        int dataSize;
        try {
            while ((dataSize = inputStream.read(data)) != -1) {
                byteBuffer.clear();
                byteBuffer.put(data, 0, dataSize);
                outChannel.write(byteBuffer);
            }
        } finally {
            close(inputStream);
        }
        return true;
    }

    public static void close(Closeable closeable) throws IOException {
        if (closeable != null) {
            closeable.close();
        }
    }

    public static void closeSliently(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String createDir(String baseDirPath, String childDirName) {
        File file = new File(baseDirPath, childDirName);
        if (file.exists() || file.mkdir()) {
            return file.getAbsolutePath();
        }
        return null;
    }
}
