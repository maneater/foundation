package com.maneater.foundation.service;

import com.maneater.foundation.entity.Admin;
import com.maneater.foundation.entity.User;
import org.springframework.data.domain.Page;

/**
 * Created by Administrator on 2015/11/6 0006.
 */
public interface IUserService {
    public User findByLoginAndPassword(String name, String password);

    public Page<User> list(int targetPage, int pagetSize);
}
