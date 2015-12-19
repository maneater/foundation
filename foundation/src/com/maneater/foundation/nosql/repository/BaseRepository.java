package com.maneater.foundation.nosql.repository;

import com.maneater.foundation.nosql.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;


public class BaseRepository<T extends BaseEntity, ID extends Serializable> {
    @Autowired
    protected MongoTemplate mongoTemplate = null;

    public T save(T item) {
        if (!StringUtils.isEmpty(item.getId())) {
            item.preUpdate();
            mongoTemplate.save(item);
        } else {
            return insert(item);
        }
        return item;
    }

    public T insert(T item) {
        item.setId(null);
        item.prePersist();
        mongoTemplate.insert(item);
        return item;
    }

    public T findOne(ID id) {
        return mongoTemplate.findById(id, getEntityClass());
    }

    public boolean setEnableStatus(ID id, Boolean value) {
        mongoTemplate.updateFirst(Query.query(Criteria.where("_id").is(id)), Update.update("enable", value), getEntityClass());
        return true;
    }

    public List<T> listAllByEnable(boolean value) {
        return mongoTemplate.find(Query.query(Criteria.where("enable").is(value)), getEntityClass());
    }

    // 获取需要操作的实体类class
    @SuppressWarnings("unchecked")
    protected Class<T> getEntityClass() {
        return ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    public List<T> findAll() {
        return mongoTemplate.findAll(getEntityClass());
    }

    public List<T> findByEnable(boolean enable) {
        return mongoTemplate.find(Query.query(Criteria.where("enable").is(enable)), getEntityClass());
    }
}
