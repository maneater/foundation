package com.maneater.foundation.listener;

import com.maneater.foundation.Config;
import com.maneater.foundation.uitl.FileUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by macbook on 15/11/20.
 */
public class StartUpListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Config.REAL_PATH = servletContextEvent.getServletContext().getRealPath("/");
        FileUtil.createDir(Config.REAL_PATH, Config.FILE_UPLOAD_DIR_NAME);
        Config.FILE_UPLOAD_REAL_DIR_PATH = Config.REAL_PATH + Config.FILE_UPLOAD_DIR_NAME;
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
