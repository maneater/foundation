package com.maneater.foundation.nosql.repository;

import com.maneater.foundation.nosql.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2015/11/6 0006.
 */
@Repository
public class UserRepository extends BaseRepository<User, String> {

    public User findByEmailAndPassword(String email, String password) {
        return null;
    }

    public User findByEmail(String userName) {
        return null;
    }

}
