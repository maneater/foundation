package com.maneater.foundation.service.impl;

import com.maneater.foundation.nosql.entity.User;
import com.maneater.foundation.nosql.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2015/11/6 0006.
 */
@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public User findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

//    public Page<User> list(int targetPage, int pageSize) {
//        return userRepository.findAll(new PageRequest(targetPage, pageSize));
//    }
    public List<User> list() {
        return userRepository.findAll();
    }

    public User findUser(String userId) {
        return userRepository.findOne(userId);
    }

    public boolean save(User user) {
        return userRepository.save(user) != null;
    }

    public boolean checkReigser(String email) {
        return (userRepository.findByEmail(email) != null);
    }

    public boolean changeEnable(String id, boolean enable) {
        return userRepository.setEnableStatus(id, enable);
    }


}
