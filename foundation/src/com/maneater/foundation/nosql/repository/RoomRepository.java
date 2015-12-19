package com.maneater.foundation.nosql.repository;

import com.maneater.foundation.nosql.entity.Room;
import com.mongodb.WriteResult;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;


@Repository
public class RoomRepository extends BaseRepository<Room, String> {

    public List<Room> findByCategoryId(String categoryId) {
        return mongoTemplate.find(Query.query(Criteria.where("categoryId").is(categoryId)), Room.class);
    }

    public boolean syncCategoryName(String categoryId, String categoryName) {
        WriteResult result = mongoTemplate.updateMulti(Query.query(Criteria.where("categoryId").is(categoryId)), Update.update("categoryName", categoryName), Room.class);
        return StringUtils.isEmpty(result.getError());
    }

}
