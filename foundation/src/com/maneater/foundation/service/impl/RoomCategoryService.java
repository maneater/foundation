package com.maneater.foundation.service.impl;

import com.maneater.foundation.nosql.entity.RoomCategory;
import com.maneater.foundation.nosql.repository.RoomCategoryRepository;
import com.maneater.foundation.nosql.repository.RoomRepository;
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
    private RoomCategoryRepository roomCategoryRepository;

    @Resource
    RoomRepository roomRepository;

    public List<RoomCategory> listAll() {
        return roomCategoryRepository.findAll();
    }

    public RoomCategory findById(String id) {
        return roomCategoryRepository.findOne(id);
    }

    public RoomCategory save(RoomCategory category) {
        if (category.getId() != null) {//update
            RoomCategory dbCategory = roomCategoryRepository.findOne(category.getId());
            boolean needSync = dbCategory != null && !dbCategory.getName().equals(category.getName());
            category = roomCategoryRepository.save(category);
            if (category != null && needSync) {
                //categoryName change
                roomRepository.syncCategoryName(category.getId(), category.getName());

            }
        } else {//create
            category = roomCategoryRepository.save(category);
        }
        return category;
    }

    public boolean changeEnable(String id, boolean value) {
        return roomCategoryRepository.setEnableStatus(id, value);
    }


    public List<RoomCategory> listAllByEnable(boolean enable) {
        return roomCategoryRepository.findByEnable(enable);
    }
}
