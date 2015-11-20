package com.maneater.foundation.repository;

import com.maneater.foundation.entity.GraphSupplier;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2015/11/19 0019.
 */
public interface GraphModelSupplierRepository extends BaseRepository<GraphSupplier> {
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "update GraphSupplier supplier set supplier.enable=:enable where supplier.id=:id")
    public Long setEnableStatus(@Param("id") Long id, @Param("enable") boolean enable);
}
