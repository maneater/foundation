package com.maneater.foundation.repository;

import com.maneater.foundation.entity.GraphModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Administrator on 2015/11/18 0018.
 */
public interface GraphModelRepository extends BaseRepository<GraphModel> {

    public List<GraphModel> findBySupplierId(long supplierId);

    public List<GraphModel> findByCategoryId(Long categoryId);

    @Modifying(clearAutomatically = true)
    @Query(value = "update GraphModel model set room.enable=:enable where room.id=:id")
    public Long setEnableStatus(@Param("id") Long id, @Param("enable") boolean enable);

    @Modifying(clearAutomatically = true)
    @Query(value = "update GraphModel model set model.category=:name where model.categoryId=:id")
    public Long syncCategoryName(@Param("id") Long categoryId, @Param("name") String categoryName);


}
