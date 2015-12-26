package com.maneater.foundation.service.impl;

import com.maneater.foundation.nosql.entity.RoomCategory;
import com.maneater.foundation.repsitory.RoomCategoryJpaRepository;
import com.maneater.foundation.repsitory.RoomJpaRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2015/11/19 0019.
 * 房间类型
 */
@Service
public class RoomCategoryService {
    @Resource
    private RoomCategoryJpaRepository roomCategoryJpaRepository;

    @Resource
    RoomJpaRepository roomJpaRepository;

    public List<RoomCategory> listAll() {
        return roomCategoryJpaRepository.findAll();
    }

    public RoomCategory findById(String id) {
        return roomCategoryJpaRepository.findOne(id);
    }

    public RoomCategory save(RoomCategory category) {
        if (category.getId() != null) {//update
            RoomCategory dbCategory = roomCategoryJpaRepository.findOne(category.getId());
            boolean needSync = dbCategory != null && !dbCategory.getName().equals(category.getName());
            category = roomCategoryJpaRepository.save(category);
            if (category != null && needSync) {
                //categoryName change
                roomJpaRepository.syncCategoryName(category.getId(), category.getName());

            }
        } else {//create
            category = roomCategoryJpaRepository.save(category);
        }
        return category;
    }

    public boolean changeEnable(String id, boolean value) {
        return roomCategoryJpaRepository.setEnableStatus(id, value)>0;
    }


    public List<RoomCategory> listAllByEnable(boolean enable) {
        return roomCategoryJpaRepository.findByEnable(enable);
    }
}
