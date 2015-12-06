package com.maneater.foundation.service.impl;

import com.maneater.foundation.entity.ExpandProperty;
import com.maneater.foundation.entity.Product;
import com.maneater.foundation.repository.ExpandPropertyRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liang on 15/12/6.
 */
@Service
public class ExpandPropertyService {
    @Resource
    private ExpandPropertyRepository expandPropertyRepository;

    public ExpandProperty save(ExpandProperty property) {
        return expandPropertyRepository.saveAndFlush(property);
    }

    public List<ExpandProperty> listAll() {
        return expandPropertyRepository.findAll();
    }

    public boolean changeEnabel(Long id, boolean enable) {
        return expandPropertyRepository.setEnableStatus(id, enable) > 0;
    }

    public ExpandProperty findById(Long id) {
        return expandPropertyRepository.findOne(id);
    }
}
