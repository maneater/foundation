package com.maneater.foundation.repository;

import com.maneater.foundation.entity.Admin;

/**
 * Created by Administrator on 2015/11/6 0006.
 */
public interface AdminRepository extends BaseRepository<Admin> {

    public Admin findByNameAndPassword(String name, String password);

}
