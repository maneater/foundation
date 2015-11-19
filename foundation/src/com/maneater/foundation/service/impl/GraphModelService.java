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

}
