package com.maneater.foundation.repsitory;

import com.maneater.foundation.nosql.entity.ProductCategoryPosition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryPositionRepository extends JpaBaseRepository<ProductCategoryPosition> {
    public List<ProductCategoryPosition> findByRoomId(String roomId);

    public ProductCategoryPosition findByRoomIdAndProductCategoryId(String roomId, String productCategoryId);

    public List<ProductCategoryPosition> findByProductCategoryId(String productCategoryId);

    public void deleteByRoomId(String roomId);
}
