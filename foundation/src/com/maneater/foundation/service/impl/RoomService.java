package com.maneater.foundation.service.impl;

import com.maneater.foundation.nosql.entity.Room;
import com.maneater.foundation.nosql.repository.RoomRepository;
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
    private RoomRepository roomRepository;

    public List<Room> listByCategoryId(String categoryId) {
        return roomRepository.findByCategoryId(categoryId);
    }

    public Room findById(String id) {
        return roomRepository.findOne(id);
    }

    public List<Room> lisAll() {
        return roomRepository.findAll();
    }

    public List<Room> listAllByEnable(boolean enable) {
        return roomRepository.findByEnable(enable);
    }

    public Room save(Room room) {
        return roomRepository.save(room);
    }

    public boolean changeEnable(String id, boolean enable) {
        return roomRepository.setEnableStatus(id, enable);
    }
}
