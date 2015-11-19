package com.maneater.foundation.service.impl;

import com.maneater.foundation.entity.GraphModelCategory;
import com.maneater.foundation.repository.GraphModelCategoryRepository;
import com.maneater.foundation.repository.GraphModelRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2015/11/19 0019.
 */
@Service
public class GraphModelCategoryService {
    @Resource
    private GraphModelCategoryRepository graphModelCategoryRepository;

    @Resource
    private GraphModelRepository graphModelRepository;

    public List<GraphModelCategory> listAll() {
        return graphModelCategoryRepository.findAll();
    }

    public GraphModelCategory findById(Long id) {
        return graphModelCategoryRepository.findOne(id);
    }

    public GraphModelCategory save(GraphModelCategory category) {
        if (category.getId() != null) {//update
            GraphModelCategory dbCategory = graphModelCategoryRepository.findOne(category.getId());
            boolean needSync = dbCategory != null && !dbCategory.getName().equals(category.getName());
            category = graphModelCategoryRepository.saveAndFlush(category);
            if (category != null && needSync) {
                //categoryName change
                graphModelRepository.syncCategoryName(category.getId(), category.getName());

            }
        } else {//create
            category = graphModelCategoryRepository.saveAndFlush(category);
        }
        return category;
    }

    public boolean changeEnable(Long id, boolean value) {
        return graphModelCategoryRepository.setEnableStatus(id, value) != null;
    }


}
