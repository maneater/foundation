package com.maneater.foundation.nosql.repository;

import com.maneater.foundation.nosql.entity.Room;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

public class RoomRepository extends BaseRepository<Room, String> {

    public List<Room> findByCategoryId(String categoryId) {
        return mongoTemplate.find(Query.query(Criteria.where("categoryId").is(categoryId)), Room.class);
    }

    public Integer syncCategoryName(String categoryId, String categoryName) {
        mongoTemplate.updateFirst(Query.query(Criteria.where("categoryId").is(categoryId)), Update.update("categoryName", categoryName), Room.class);
        return null;
    }

}
