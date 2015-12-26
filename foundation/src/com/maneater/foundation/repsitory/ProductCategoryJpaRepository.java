package com.maneater.foundation.repsitory;

import com.maneater.foundation.nosql.entity.ProductCategory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductCategoryJpaRepository extends JpaBaseRepository<ProductCategory> {
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "update ProductCategory category set category.enable=:enable where category.id=:id")
    public Integer setEnableStatus(@Param("id") String id, @Param("enable") boolean enable);
}
