package com.maneater.foundation.service.impl;

import com.maneater.foundation.entity.GraphModelCategory;
import com.maneater.foundation.entity.GraphRoomCategory;
import com.maneater.foundation.repository.GraphModelCategoryRepository;
import com.maneater.foundation.repository.GraphModelRepository;
import com.maneater.foundation.repository.GraphRoomCategoryRepository;
import com.maneater.foundation.repository.GraphRoomRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2015/11/19 0019.
 */
@Service
public class GraphRoomCategoryService {
    @Resource
    private GraphRoomCategoryRepository graphRoomCategoryRepository;

    @Resource
    GraphRoomRepository graphRoomRepository;

    public List<GraphRoomCategory> listAll() {
        return graphRoomCategoryRepository.findAll();
    }

    public GraphRoomCategory findById(Long id) {
        return graphRoomCategoryRepository.findOne(id);
    }

    public GraphRoomCategory save(GraphRoomCategory category) {
        if (category.getId() != null) {//update
            GraphRoomCategory dbCategory = graphRoomCategoryRepository.findOne(category.getId());
            boolean needSync = dbCategory != null && !dbCategory.getName().equals(category.getName());
            category = graphRoomCategoryRepository.saveAndFlush(category);
            if (category != null && needSync) {
                //categoryName change
                graphRoomRepository.syncCategoryName(category.getId(), category.getName());

            }
        } else {//create
            category = graphRoomCategoryRepository.saveAndFlush(category);
        }
        return category;
    }

    public boolean changeEnable(Long id, boolean value) {
        return graphRoomCategoryRepository.setEnableStatus(id, value) != null;
    }


}
