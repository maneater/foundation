package com.maneater.foundation.service.impl;

import com.maneater.foundation.entity.Product;
import com.maneater.foundation.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2015/11/19 0019.
 */
@Service
public class ProductService {

    @Resource
    private ProductRepository productRepository;

    public List<Product> listByCategoryId(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    public List<Product> listAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findOne(id);
    }

    public boolean changeEnabel(Long id, boolean enable) {
        return productRepository.setEnableStatus(id, enable) != null;
    }

    public Product save(Product product) {
        return productRepository.saveAndFlush(product);
    }
}
