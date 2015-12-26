package com.maneater.foundation.service.impl;

import com.maneater.foundation.nosql.entity.Room;
import com.maneater.foundation.repsitory.RoomJpaRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2015/11/19 0019.
 * 房间
 */
@Service
public class RoomService {

    @Resource
    private RoomJpaRepository roomJpaRepository;

    public List<Room> listByCategoryId(String categoryId) {
        return roomJpaRepository.findByCategoryId(categoryId);
    }

    public Room findById(String id) {
        return roomJpaRepository.findOne(id);
    }

    public List<Room> lisAll() {
        return roomJpaRepository.findAll();
    }

    public List<Room> listAllByEnable(boolean enable) {
        return roomJpaRepository.findByEnable(enable);
    }

    public Room save(Room room) {
        return roomJpaRepository.save(room);
    }

    public boolean changeEnable(String id, boolean enable) {
        return roomJpaRepository.setEnableStatus(id, enable)>0;
    }
}
