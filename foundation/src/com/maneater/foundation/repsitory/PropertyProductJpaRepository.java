package com.maneater.foundation.repsitory;

import com.maneater.foundation.nosql.entity.PropertyProduct;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by liang on 15/12/26.
 */
public interface PropertyProductJpaRepository extends JpaBaseRepository<PropertyProduct> {
    @Modifying(clearAutomatically = true)
    @Transactional
    public void deleteByProductId(String productId);
}
