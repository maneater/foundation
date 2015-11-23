package com.maneater.foundation.repository;

import com.maneater.foundation.entity.GraphModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2015/11/18 0018.
 */
public interface GraphModelRepository extends BaseRepository<GraphModel> {

    public List<GraphModel> findBySupplierId(long supplierId);

    public List<GraphModel> findByCategoryId(Long categoryId);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "update GraphModel model set model.enable=:enable where model.id=:id")
    public Integer setEnableStatus(@Param("id") Long id, @Param("enable") boolean enable);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update GraphModel model set model.categoryName=:name where model.categoryId=:id")
    public Integer syncCategoryName(@Param("id") Long categoryId, @Param("name") String categoryName);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update GraphModel model set model.supplierName=:name where model.supplierId=:id")
    public Integer syncSupplierName(@Param("id") Long id, @Param("name") String name);

}
