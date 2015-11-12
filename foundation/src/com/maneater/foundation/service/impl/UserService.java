package com.maneater.foundation.service.impl;

import com.maneater.foundation.entity.User;
import com.maneater.foundation.repository.UserRepository;
import com.maneater.foundation.service.IUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2015/11/6 0006.
 */
@Service
public class UserService implements IUserService {
    @Resource
    private UserRepository userDao;

    @Override
    public User findByLoginAndPassword(String name, String password) {
        return userDao.findByLoginAndPassword(name, password);
    }

    @Override
    public Page<User> list(int targetPage, int pageSize) {
        return userDao.findAll(new PageRequest(targetPage, pageSize));
    }

    @Override
    public User findUser(long userId) {
        return userDao.findOne(userId);
    }

    @Override
    public boolean save(User user) {
        return userDao.save(user) != null;
    }


}
