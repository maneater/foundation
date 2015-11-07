package com.maneater.foundation.service;

import com.maneater.foundation.entity.Admin;

/**
 * Created by Administrator on 2015/11/6 0006.
 */
public interface IAdminService {
    public Admin findByNameAndPass(String name, String password);
}
