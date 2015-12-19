//package com.maneater.foundation.repository;
//
//import com.maneater.foundation.entity.Room;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
///**
// * Created by Administrator on 2015/11/18 0018.
// */
//public interface RoomRepository extends BaseRepository<Room> {
//
//    @Modifying(clearAutomatically = true)
//    @Transactional
//    @Query(value = "update Room room set room.enable=:enable where room.id=:id")
//    public Integer setEnableStatus(@Param("id") Long id, @Param("enable") boolean enable);
//
//    public List<Room> findByCategoryId(Long categoryId);
//
//    @Transactional
//    @Modifying(clearAutomatically = true)
//    @Query(value = "update Room room set room.categoryName=:name where room.categoryId=:id")
//    public Integer syncCategoryName(@Param("id") Long categoryId, @Param("name") String categoryName);
//
//}
