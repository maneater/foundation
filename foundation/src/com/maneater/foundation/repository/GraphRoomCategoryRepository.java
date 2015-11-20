package com.maneater.foundation.repository;

import com.maneater.foundation.entity.GraphModelCategory;
import com.maneater.foundation.entity.GraphRoomCategory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2015/11/19 0019.
 */
@Repository
public interface GraphRoomCategoryRepository extends BaseRepository<GraphRoomCategory> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "update GraphRoomCategory category set category.enable=:enable where category.id=:id")
    public Integer setEnableStatus(@Param("id") Long id, @Param("enable") boolean enable);
}
