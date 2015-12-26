//package com.maneater.foundation.nosql.repository;
//
//import com.maneater.foundation.nosql.entity.User;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class UserRepository extends BaseRepository<User, String> {
//
//    public User findByEmailAndPassword(String email, String password) {
//        return mongoTemplate.findOne(Query.query(Criteria.where("email").is(email)).addCriteria(Criteria.where("password").is(password)), User.class);
//    }
//
//    public User findByEmail(String userName) {
//        return mongoTemplate.findOne(Query.query(Criteria.where("email").is(userName)), User.class);
//    }
//
//}
