package com.maneater.foundation.repository;

import com.maneater.foundation.entity.GraphModelCategory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2015/11/19 0019.
 */
@Repository
public interface GraphModelCategoryRepository extends BaseRepository<GraphModelCategory> {


    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "update GraphModelCategory category set category.enable=:enable where category.id=:id")
    public Long setEnableStatus(@Param("id") Long id, @Param("enable") boolean enable);
}
