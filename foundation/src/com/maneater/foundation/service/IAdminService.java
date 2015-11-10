package com.maneater.foundation.service;

import com.maneater.foundation.entity.Admin;
import com.maneater.foundation.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2015/11/6 0006.
 */
public interface IAdminService {
    public Admin findByNameAndPass(String name, String password);

    public List<Admin> listUsers(int targetPage, int pageSize);
}
