package com.maneater.foundation.service.impl;

import com.maneater.foundation.entity.GraphModel;
import com.maneater.foundation.repository.GraphModelRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2015/11/19 0019.
 */
@Service
public class GraphModelService {

    @Resource
    private GraphModelRepository graphModelRepository;

    public List<GraphModel> listBySupplierId(Long supplierId) {
        return graphModelRepository.findBySupplierId(supplierId);
    }

    public List<GraphModel> listByCategoryId(Long categoryId) {
        return graphModelRepository.findByCategoryId(categoryId);
    }

    public List<GraphModel> listAll() {
        return graphModelRepository.findAll();
    }

    public GraphModel findById(Long id) {
        return graphModelRepository.findOne(id);
    }

    public boolean changeEnabel(Long id, boolean enable) {
        return graphModelRepository.setEnableStatus(id, enable) != null;
    }

    public GraphModel save(GraphModel graphModel) {
        return graphModelRepository.saveAndFlush(graphModel);
    }
}
