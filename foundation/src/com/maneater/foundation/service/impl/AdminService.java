package com.maneater.foundation.service.impl;

import com.maneater.foundation.Config;
import com.maneater.foundation.nosql.entity.Admin;
import com.maneater.foundation.nosql.repository.AdminRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminService {
    @Resource
    private AdminRepository adminRepository;

    public Admin findByNameAndPass(String name, String password) {
        return adminRepository.findByNameAndPassword(name, password);
    }

    public void initAdmin() {
        List<Admin> adminList = adminRepository.findAll();
        if (CollectionUtils.isEmpty(adminList)) {
            Admin admin = new Admin();
            admin.setName(Config.DEFAULT_ADMIN_NAME);
            admin.setPassword(Config.DEFAULT_ADMIN_PASSWORD);
            admin.setInfo("create by auto ");
            adminRepository.save(admin);
        }
    }
}
