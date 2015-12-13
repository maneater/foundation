package com.maneater.foundation.nosql.repository;


import com.maneater.foundation.nosql.entity.OrderInfo;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository extends BaseRepository<OrderInfo, String> {

    public List<OrderInfo> findByStatus(String userId, int status) {
        return mongoTemplate.find(Query.query(Criteria.where("status").is(status).and("userId").is(userId)), OrderInfo.class);
    }

    public List<OrderInfo> findByStatus(int status) {
        return mongoTemplate.find(Query.query(Criteria.where("status").is(status)), OrderInfo.class);
    }

}
