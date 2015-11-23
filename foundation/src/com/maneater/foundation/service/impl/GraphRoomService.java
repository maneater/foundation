package com.maneater.foundation.service.impl;

import com.maneater.foundation.entity.GraphModel;
import com.maneater.foundation.entity.GraphRoom;
import com.maneater.foundation.repository.GraphModelRepository;
import com.maneater.foundation.repository.GraphRoomRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2015/11/19 0019.
 */
@Service
public class GraphRoomService {

    @Resource
    private GraphRoomRepository graphRoomRepository;

    public List<GraphRoom> listByCategoryId(Long categoryId) {
        return graphRoomRepository.findByCategoryId(categoryId);
    }

    public GraphRoom findById(Long id) {
        return graphRoomRepository.findOne(id);
    }

    public List<GraphRoom> lisAll() {
        return graphRoomRepository.findAll();
    }

    public List<GraphRoom> listAllByEnable(boolean enable) {
        return graphRoomRepository.findByEnable(enable);
    }

    public GraphRoom save(GraphRoom graphRoom) {
        return graphRoomRepository.saveAndFlush(graphRoom);
    }

    public boolean changeEnabel(Long id, boolean enable) {
        return graphRoomRepository.setEnableStatus(id, enable) != null;
    }
}
