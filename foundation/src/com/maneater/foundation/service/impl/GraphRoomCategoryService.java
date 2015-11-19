package com.maneater.foundation.service.impl;

import com.maneater.foundation.entity.GraphModelCategory;
import com.maneater.foundation.entity.GraphRoomCategory;
import com.maneater.foundation.repository.GraphModelCategoryRepository;
import com.maneater.foundation.repository.GraphModelRepository;
import com.maneater.foundation.repository.GraphRoomCategoryRepository;
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

    public List<GraphRoomCategory> listAll() {
        return graphRoomCategoryRepository.findAll();
    }

    public GraphRoomCategory findById(Long id) {
        return graphRoomCategoryRepository.findOne(id);
    }

    public GraphRoomCategory save(GraphRoomCategory category) {
        return graphRoomCategoryRepository.saveAndFlush(category);
    }

    public boolean changeEnable(Long id, boolean value) {
        return graphRoomCategoryRepository.setEnableStatus(id, value) != null;
    }


}
