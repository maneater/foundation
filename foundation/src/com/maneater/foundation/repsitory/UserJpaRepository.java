package com.maneater.foundation.repsitory;

import com.maneater.foundation.nosql.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserJpaRepository extends JpaBaseRepository<User> {

    public User findByEmailAndPassword(String email, String password);

    public User findByEmail(String userName);


    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "update User user set user.enable=:enable where user.id=:id")
    public Integer setEnableStatus(@Param("id") String id, @Param("enable") boolean enable);

}
