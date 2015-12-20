package com.maneater.foundation.service.impl;

import com.maneater.foundation.nosql.entity.Product;
import com.maneater.foundation.nosql.entity.PropertyProduct;
import com.maneater.foundation.nosql.repository.ProductRepository;
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
    private ProductRepository productRepository;

    public List<Product> listByCategoryId(String categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    public List<Product> listAll() {
        return productRepository.findAll();
    }

    public Product findById(String id) {
        return productRepository.findOne(id);
    }

    public boolean changeEnable(String id, boolean enable) {
        return productRepository.setEnableStatus(id, enable);
    }

    public Product save(Product product) {
        checkExpandProduct(product);
        return productRepository.save(product);
    }

    private void checkExpandProduct(Product product) {
        List<PropertyProduct> propertyProductList = product.getPropertyProductList();
        if (propertyProductList != null) {
            for (int i = 0; i < propertyProductList.size(); i++) {
                if (propertyProductList.get(i) == null || StringUtils.isEmpty(propertyProductList.get(i).getPropertyName()) || StringUtils.isEmpty(propertyProductList.get(i).getPropertyValue()) || StringUtils.isEmpty(propertyProductList.get(i).getProductCode()) || StringUtils.isEmpty(propertyProductList.get(i).getProductPrice())) {
                    propertyProductList.remove(i);
                    i--;
                }
            }
        }
    }

    public List<Product> listAllByEnable(boolean value) {
        return productRepository.listAllByEnable(value);
    }

    public Product findByCode(String productCode) {
        return productRepository.findByCode(productCode);
    }

}
