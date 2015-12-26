package com.maneater.foundation.service.impl;

import com.maneater.foundation.nosql.entity.ExpandProperty;
import com.maneater.foundation.nosql.entity.ProductCategory;
import com.maneater.foundation.repsitory.ProductCategoryJpaRepository;
import com.maneater.foundation.repsitory.ProductJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductCategoryService {
    //    @Resource
//    private ProductCategoryRepository productCategoryJpaRepository;
    @Resource
    private ProductCategoryJpaRepository productCategoryJpaRepository;

    @Resource
    private ProductJpaRepository productJpaRepository;

    public List<ProductCategory> listAll() {
        return productCategoryJpaRepository.findAll();
    }

    public ProductCategory findById(String id) {
        return productCategoryJpaRepository.findOne(id);
    }

    public ProductCategory save(ProductCategory category) {
        reCheckPropertys(category);
        if (!StringUtils.isEmpty(category.getId())) {//update
            ProductCategory dbCategory = productCategoryJpaRepository.findOne(category.getId());
            boolean needSync = dbCategory != null && !dbCategory.getName().equals(category.getName());
            category = productCategoryJpaRepository.save(category);
            if (category != null && needSync) {
                //categoryName change
                productJpaRepository.syncCategoryName(category.getId(), category.getName());

            }
        } else {//create
            category = productCategoryJpaRepository.save(category);
        }
        return category;
    }

    private void reCheckPropertys(ProductCategory category) {
        if (category != null && category.getExpandPropertyList() != null) {
            int propertySize = category.getExpandPropertyList().size();
            for (int i = 0; i < propertySize; i++) {
                ExpandProperty expandProperty = category.getExpandPropertyList().get(i);
                if (StringUtils.isEmpty(expandProperty.getName())) {
                    category.getExpandPropertyList().remove(i);
                    propertySize--;
                    i--;
                    continue;
                }
                if (StringUtils.isEmpty(expandProperty.getId())) {
                    expandProperty.setId(null);
                }
                expandProperty.setProductCategory(category);
            }
        }
    }

    public boolean changeEnable(String id, boolean value) {
        return productCategoryJpaRepository.setEnableStatus(id, value)>0;
    }


    public List<ProductCategory> listAllByEnable(boolean value) {
        return productCategoryJpaRepository.findByEnable(value);
    }
}
