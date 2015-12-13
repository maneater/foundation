//package com.maneater.foundation.service.impl;
//
//import com.maneater.foundation.nosql.entity.ExpandProperty;
//import com.maneater.foundation.nosql.repository.BaseRepository;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.List;
//
///**
// * Created by liang on 15/12/6.
// */
//@Service
//public class ExpandPropertyService {
//    @Resource
//    private BaseRepository<ExpandProperty, String> expandPropertyRepository;
//
//    public ExpandProperty save(ExpandProperty property) {
//        return expandPropertyRepository.save(property);
//    }
//
//    public List<ExpandProperty> listAll() {
//        return expandPropertyRepository.findAll();
//    }
//
//    public boolean changeEnabel(String id, boolean enable) {
//        expandPropertyRepository.setEnableStatus(id, enable);
//        return true;
//    }
//
//    public ExpandProperty findById(String id) {
//        return expandPropertyRepository.findOne(id);
//    }
//}
