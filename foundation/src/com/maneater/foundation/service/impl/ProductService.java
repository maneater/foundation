package com.maneater.foundation.service.impl;

import com.maneater.foundation.nosql.entity.Product;
import com.maneater.foundation.nosql.entity.PropertyProduct;
import com.maneater.foundation.repsitory.ProductJpaRepository;
import com.maneater.foundation.repsitory.PropertyProductJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2015/11/19 0019.
 */
@Service
public class ProductService {

    @Resource
    private ProductJpaRepository productJpaRepository;

    @Resource
    private PropertyProductJpaRepository propertyProductJpaRepository;

    public List<Product> listByCategoryId(String categoryId) {
        return productJpaRepository.findByCategoryId(categoryId);
    }

    public List<Product> listAll() {
        return productJpaRepository.findAll();
    }

    public Product findById(String id) {
        return productJpaRepository.findOne(id);
    }

    public boolean changeEnable(String id, boolean enable) {
        return productJpaRepository.setEnableStatus(id, enable) > 0;
    }

    public Product save(Product product) {
        checkExpandProduct(product);
        propertyProductJpaRepository.deleteByProductId(product.getId());
        return productJpaRepository.save(product);
    }

    private void checkExpandProduct(Product product) {
        List<PropertyProduct> propertyProductList = product.getPropertyProductList();
        if (propertyProductList != null) {
            for (int i = 0; i < propertyProductList.size(); i++) {
                if (propertyProductList.get(i) == null || StringUtils.isEmpty(propertyProductList.get(i).getPropertyName()) || StringUtils.isEmpty(propertyProductList.get(i).getPropertyValue()) || StringUtils.isEmpty(propertyProductList.get(i).getProductCode()) || StringUtils.isEmpty(propertyProductList.get(i).getProductPrice())) {
                    propertyProductList.remove(i);
                    i--;
                    continue;
                }
                propertyProductList.get(i).setName(propertyProductList.get(i).getPropertyName());
                propertyProductList.get(i).setProduct(product);
            }
        }
    }

    public List<Product> listAllByEnable(boolean value) {
        return productJpaRepository.findByEnable(value);
    }

    public Product findByCode(String productCode) {
        List<Product> productList = productJpaRepository.findByCode(productCode);
        return productList != null ? productList.get(0) : null;
    }

}
