package com.maneater.foundation.service.impl;

import com.maneater.foundation.nosql.entity.ExpandProperty;
import com.maneater.foundation.nosql.entity.ProductCategory;
import com.maneater.foundation.nosql.repository.ProductCategoryRepository;
import com.maneater.foundation.nosql.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductCategoryService {
    @Resource
    private ProductCategoryRepository productCategoryRepository;

    @Resource
    private ProductRepository productRepository;

    public List<ProductCategory> listAll() {
        return productCategoryRepository.findAll();
    }

    public ProductCategory findById(String id) {
        return productCategoryRepository.findOne(id);
    }

    public ProductCategory save(ProductCategory category) {
        reCheckPropertys(category);
        if (!StringUtils.isEmpty(category.getId())) {//update
            ProductCategory dbCategory = productCategoryRepository.findOne(category.getId());
            boolean needSync = dbCategory != null && !dbCategory.getName().equals(category.getName());
            category = productCategoryRepository.save(category);
            if (category != null && needSync) {
                //categoryName change
                productRepository.syncCategoryName(category.getId(), category.getName());

            }
        } else {//create
            category = productCategoryRepository.save(category);
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
            }
        }
    }

    public boolean changeEnable(String id, boolean value) {
        return productCategoryRepository.setEnableStatus(id, value);
    }


    public List<ProductCategory> listAllByEnable(boolean value) {
        return productCategoryRepository.listAllByEnable(value);
    }
}
