package com.maneater.foundation.uitl;

import com.maneater.foundation.entity.GraphModel;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import java.io.*;

/**
 * Created by macbook on 15/11/18.
 */
public class ZipPropertiesUtil {

    private final static Logger logger = Logger.getLogger(ZipPropertiesUtil.class);
    static String PROPERTIES_TPL;

    public static String getPathLocation(String appPath, String path) {
        if (!StringUtils.isEmpty(path)) {
            if (!path.toUpperCase().startsWith("HTTP://")) {
                return appPath + "/" + path;
            }
        }
        return path;
    }

    private static String loadTpl() {
        if (!StringUtils.isEmpty(PROPERTIES_TPL)) {
            return PROPERTIES_TPL;
        }
        StringBuilder tmpString = new StringBuilder();
        InputStream inputStream = null;
        try {
            inputStream = ZipPropertiesUtil.class.getClassLoader().getResourceAsStream("tpl_graph_model_pro");
            if (inputStream != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String lineStr;
                while ((lineStr = bufferedReader.readLine()) != null) {
                    tmpString.append(lineStr);
                    tmpString.append("\r\n");
                }
            }
        } catch (IOException e) {
            logger.error(e);
        } finally {
            FileUtil.closeSliently(inputStream);
        }
        PROPERTIES_TPL = tmpString.toString();
        return PROPERTIES_TPL;
    }

    public static String createZipProper(GraphModel graphModel) {
        return loadTpl().replace("{numId}", forString(graphModel.getId()))
                .replace("{name}", forString(graphModel.getName()))
                .replace("{sequenceName}", forString(graphModel.getSequenceName()))
                .replace("{tags}", forString(graphModel.getTags()))
                .replace("{creationDate}", forString(""))
                .replace("{category}", forString(graphModel.getCategory()))
                .replace("{icon}", forString(graphModel.getIcon()))
                .replace("{iconDigest}", forString(graphModel.getIconDigest()))
                .replace("{model}", forString(graphModel.getModel()))
                .replace("{modelDigest}", forString(graphModel.getModelDigest()))
                .replace("{multiPartModel}", forString(graphModel.isMultiPartModel()))
                .replace("{width}", forString(graphModel.getWidth()))
                .replace("{depth}", forString(graphModel.getDepth()))
                .replace("{height}", forString(graphModel.getHeight()))
                .replace("{movable}", forString(graphModel.isMovable()))
                .replace("{doorOrWindow}", forString(graphModel.isDoorOrWindow()))
                .replace("{creator}", forString(""));

    }

    public static String forString(Object object) {
        return object != null ? String.valueOf(object) : "";
    }

}
