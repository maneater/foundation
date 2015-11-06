package com.maneater.foundation.service.impl;

import com.maneater.foundation.entity.Admin;
import com.maneater.foundation.repository.AdminRepository;
import com.maneater.foundation.service.IAdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2015/11/6 0006.
 */
@Service
public class AdminService implements IAdminService {
    @Resource
    private AdminRepository adminDao;

    @Override
    public Admin login(String name, String password) {
        return adminDao.findByNameAndPassword(name, password);
    }
}
