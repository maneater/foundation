package com.maneater.foundation.repsitory;

import com.maneater.foundation.nosql.entity.RoomCategory;
import com.maneater.foundation.nosql.repository.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2015/11/19 0019.
 * 房间类型
 */
@Repository
public interface RoomCategoryJpaRepository extends JpaBaseRepository<RoomCategory> {
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "update RoomCategory category set category.enable=:enable where category.id=:id")
    public Integer setEnableStatus(@Param("id") String id, @Param("enable") boolean enable);
}
