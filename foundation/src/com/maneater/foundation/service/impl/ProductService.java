package com.maneater.foundation.service.impl;

import com.maneater.foundation.nosql.entity.Product;
import com.maneater.foundation.nosql.entity.PropertyProduct;
import com.maneater.foundation.repsitory.ProductJpaRepository;
import com.maneater.foundation.repsitory.PropertyProductJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
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
        propertyProductJpaRepository.deleteByProductId(product.getId());
        checkExpandProduct(product);
        //全量更新，删除已有的，保存新的
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

    public PropertyProduct findPropertyProductByCode(String productCode) {
        PropertyProduct propertyProduct = null;
        Product product = findByCode(productCode);
        if (product != null) {
            if (product.getCode().equals(productCode)) {
                propertyProduct = new PropertyProduct();
                propertyProduct.setProductCode(productCode);
                propertyProduct.setEffectPicUrl(product.getEffectPicUrl());
                propertyProduct.setProduct(product);
                propertyProduct.setProductPrice(product.getPrice());
                propertyProduct.setPropertyPicUrl(product.getDescDetail());
                //TODO other
            } else if (!CollectionUtils.isEmpty(product.getPropertyProductList())) {
                for (PropertyProduct curPor : product.getPropertyProductList()) {
                    if (curPor.getProductCode().equals(productCode)) {
                        return curPor;
                    }
                }

            }
        }
        return propertyProduct;
    }

}
