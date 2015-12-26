package com.maneater.foundation.repsitory;

import com.maneater.foundation.nosql.entity.Admin;
import com.maneater.foundation.nosql.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminJpaRepository extends JpaBaseRepository<Admin> {

    public Admin findByNameAndPassword(String name, String password);

}
