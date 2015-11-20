package com.maneater.foundation.repository;

import com.maneater.foundation.entity.GraphModel;
import com.maneater.foundation.entity.GraphRoom;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2015/11/18 0018.
 */
public interface GraphRoomRepository extends BaseRepository<GraphRoom> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "update GraphRoom room set room.enable=:enable where room.id=:id")
    public Long setEnableStatus(@Param("id") Long id, @Param("enable") boolean enable);

    public List<GraphRoom> findByCategoryId(Long categoryId);
}
