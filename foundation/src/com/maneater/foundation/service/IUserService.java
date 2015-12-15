package com.maneater.foundation.service;

import com.maneater.foundation.entity.Admin;
import com.maneater.foundation.entity.User;
import com.maneater.foundation.vo.Result;
import org.springframework.data.domain.Page;

/**
 * Created by Administrator on 2015/11/6 0006.
 */
public interface IUserService {
    public User findByEmailAndPassword(String name, String password);

    public Page<User> list(int targetPage, int pagetSize);

    User findUser(long userId);

    boolean save(User user);

    boolean checkReigser(String email);

    boolean changeEnable(String id, boolean enable);
}
