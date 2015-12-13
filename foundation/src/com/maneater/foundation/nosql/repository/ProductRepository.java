package com.maneater.foundation.nosql.repository;

import com.maneater.foundation.nosql.entity.Product;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository extends BaseRepository<Product, String> {

    public List<Product> findByCategoryId(Long categoryId) {
        return null;
    }

    public Integer syncCategoryName(@Param("id") String categoryId, @Param("name") String categoryName) {
        return null;
    }

}
