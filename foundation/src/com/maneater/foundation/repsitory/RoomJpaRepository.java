package com.maneater.foundation.repsitory;

import com.maneater.foundation.nosql.entity.Room;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface RoomJpaRepository extends JpaBaseRepository<Room> {

    public List<Room> findByCategoryId(String categoryId);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "update Room room set room.enable=:enable where room.id=:id")
    public Integer setEnableStatus(@Param("id") String id, @Param("enable") boolean enable);

    public List<Room> findByCategoryId(Long categoryId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update Room room set room.categoryName=:name where room.categoryId=:id")
    public Integer syncCategoryName(@Param("id") String categoryId, @Param("name") String categoryName);
}
