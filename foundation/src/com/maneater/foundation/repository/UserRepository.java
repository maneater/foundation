package com.maneater.foundation.repository;

import com.maneater.foundation.entity.User;

/**
 * Created by Administrator on 2015/11/6 0006.
 */
public interface UserRepository extends BaseRepository<User> {

    public User findByLoginAndPassword(String name, String password);

}
