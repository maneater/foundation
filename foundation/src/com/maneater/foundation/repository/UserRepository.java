//package com.maneater.foundation.repository;
//
//import com.maneater.foundation.entity.User;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// * Created by Administrator on 2015/11/6 0006.
// */
//public interface UserRepository extends BaseRepository<User> {
//
//    public User findByEmailAndPassword(String email, String password);
//
//    User findByEmail(String userName);
//
//    @Modifying(clearAutomatically = true)
//    @Transactional
//    @Query(value = "update User item set item.enable=:enable where item.id=:id")
//    public Integer setEnableStatus(@Param("id") Long id, @Param("enable") boolean enable);
//}
