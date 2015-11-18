package com.maneater.foundation.service.impl;

import com.maneater.foundation.entity.GraphModel;
import com.maneater.foundation.entity.Supplier;
import com.maneater.foundation.repository.GraphModelRepository;
import com.maneater.foundation.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2015/11/18 0018.
 */
@Service
public class SupplierService {
    @Resource
    private SupplierRepository supplierRepository;
    @Resource
    private GraphModelRepository graphModelRepository;

    public List<GraphModel> listGraphModelBySupplier(long supplierId) {
        return graphModelRepository.findBySupplierId(supplierId);
    }

    public List<Supplier> listAllSupplier() {
        return supplierRepository.findAll();
    }

}
