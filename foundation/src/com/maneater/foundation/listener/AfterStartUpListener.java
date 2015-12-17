package com.maneater.foundation.listener;

import com.maneater.foundation.service.impl.AdminService;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.web.context.WebApplicationContext;

public class AfterStartUpListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent.getSource() instanceof WebApplicationContext) {
            WebApplicationContext applicationContext = (WebApplicationContext) applicationEvent.getSource();
            AdminService adminService = applicationContext.getAutowireCapableBeanFactory().getBean(AdminService.class);
            adminService.initAdmin();
        }
    }
}
