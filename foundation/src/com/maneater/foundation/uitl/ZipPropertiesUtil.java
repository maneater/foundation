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
        return loadTpl().replace("{numId}", forString(graphModel.getId())).replace("{name}", forString(graphModel.getName()));
    }

    public static String forString(Object object) {
        return object != null ? String.valueOf(object) : "";
    }

}
