package com.maneater.foundation.service.impl;

import com.maneater.foundation.entity.ProductCategory;
import com.maneater.foundation.repository.ProductCategoryRepository;
import com.maneater.foundation.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2015/11/19 0019.
 */
@Service
public class ProductCategoryService {
    @Resource
    private ProductCategoryRepository productCategoryRepository;

    @Resource
    private ProductRepository productRepository;

    public List<ProductCategory> listAll() {
        return productCategoryRepository.findAll();
    }

    public ProductCategory findById(Long id) {
        return productCategoryRepository.findOne(id);
    }

    public ProductCategory save(ProductCategory category) {
        if (category.getId() != null) {//update
            ProductCategory dbCategory = productCategoryRepository.findOne(category.getId());
            boolean needSync = dbCategory != null && !dbCategory.getName().equals(category.getName());
            category = productCategoryRepository.saveAndFlush(category);
            if (category != null && needSync) {
                //categoryName change
                productRepository.syncCategoryName(category.getId(), category.getName());

            }
        } else {//create
            category = productCategoryRepository.saveAndFlush(category);
        }
        return category;
    }

    public boolean changeEnable(Long id, boolean value) {
        return productCategoryRepository.setEnableStatus(id, value) != null;
    }


}
