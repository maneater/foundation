//package com.maneater.foundation.uitl;
//
//import com.maneater.foundation.entity.Product;
//import org.apache.log4j.Logger;
//import org.springframework.util.StringUtils;
//
//import java.io.*;
//
///**
// * Created by macbook on 15/11/18.
// */
//public class ZipPropertiesUtil {
//
//    private final static Logger logger = Logger.getLogger(ZipPropertiesUtil.class);
//    static String PROPERTIES_TPL;
//
//    public static String getPathLocation(String appPath, String path) {
//        if (!StringUtils.isEmpty(path)) {
//            if (!path.toUpperCase().startsWith("HTTP://")) {
//                return appPath + "/" + path;
//            }
//        }
//        return path;
//    }
//
//    private static String loadTpl() {
//        if (!StringUtils.isEmpty(PROPERTIES_TPL)) {
//            return PROPERTIES_TPL;
//        }
//        StringBuilder tmpString = new StringBuilder();
//        InputStream inputStream = null;
//        try {
//            inputStream = ZipPropertiesUtil.class.getClassLoader().getResourceAsStream("tpl_graph_model_pro");
//            if (inputStream != null) {
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//                String lineStr;
//                while ((lineStr = bufferedReader.readLine()) != null) {
//                    tmpString.append(lineStr);
//                    tmpString.append("\r\n");
//                }
//            }
//        } catch (IOException e) {
//            logger.error(e);
//        } finally {
//            FileUtil.closeSliently(inputStream);
//        }
//        PROPERTIES_TPL = tmpString.toString();
//        return PROPERTIES_TPL;
//    }
//
////    public static String createZipProper(Product product, int index) {
////        return loadTpl().replace("{numId}", forString(index))
////                .replace("{name}", forString(product.getName()))
////                .replace("{sequenceName}", forString(product.getSequenceName()))
////                .replace("{tags}", forString(product.getTags()))
////                .replace("{creationDate}", forString(""))
////                .replace("{category}", forString(product.getCategoryName()))
////                .replace("{icon}", forString(product.getIcon()))
////                .replace("{iconDigest}", forString(product.getIconDigest()))
////                .replace("{model}", forString(product.getModel()))
////                .replace("{modelDigest}", forString(product.getModelDigest()))
////                .replace("{multiPartModel}", forString(product.isMultiPartModel()))
////                .replace("{width}", forString(product.getWidth()))
////                .replace("{depth}", forString(product.getDepth()))
////                .replace("{height}", forString(product.getHeight()))
////                .replace("{movable}", forString(product.isMovable()))
////                .replace("{doorOrWindow}", forString(product.isDoorOrWindow()))
////                .replace("{dropOnTopElevation}", forString(product.getDropOnTopElevation()))
////                .replace("{creator}", forString(""));
////
////    }
//
//    public static String forString(Object object) {
//        return object != null ? String.valueOf(object) : "";
//    }
//
//}
