//package com.maneater.foundation.nosql.repository;
//
//import com.maneater.foundation.nosql.entity.Admin;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.stereotype.Repository;
//import org.springframework.util.CollectionUtils;
//
//import java.util.List;
//@Repository
//public class AdminRepository extends BaseRepository<Admin, String> {
//    public Admin findByNameAndPassword(String name, String password) {
//        List<Admin> adminList = mongoTemplate.find(Query.query(Criteria.where("name").is(name)).addCriteria(Criteria.where("password").is(password)), Admin.class);
//        if (!CollectionUtils.isEmpty(adminList)) {
//            return adminList.get(0);
//        }
//        return null;
//    }
//
//}
