package com.maneater.foundation.service.impl;

import com.maneater.foundation.nosql.entity.User;
import com.maneater.foundation.repsitory.UserJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2015/11/6 0006.
 */
@Service
public class UserService {
    @Resource
    private UserJpaRepository userJpaRepository;

    public User findByEmailAndPassword(String email, String password) {
        return userJpaRepository.findByEmailAndPassword(email, password);
    }

    //
    public Page<User> list(int targetPage, int pageSize) {
        return userJpaRepository.findAll(new PageRequest(targetPage, pageSize));
    }
    public List<User> list() {
        return userJpaRepository.findAll();
    }

    public User findUser(String userId) {
        return userJpaRepository.findOne(userId);
    }

    public boolean save(User user) {
        return userJpaRepository.save(user) != null;
    }

    public boolean checkReigser(String email) {
        return (userJpaRepository.findByEmail(email) != null);
    }

    public boolean changeEnable(String id, boolean enable) {
        return userJpaRepository.setEnableStatus(id, enable)>0;
    }


}
