package com.maneater.foundation.service.impl;

import com.maneater.foundation.nosql.entity.ProductCategory;
import com.maneater.foundation.nosql.entity.ProductCategoryPosition;
import com.maneater.foundation.nosql.entity.Room;
import com.maneater.foundation.repsitory.ProductCategoryJpaRepository;
import com.maneater.foundation.repsitory.ProductCategoryPositionRepository;
import com.maneater.foundation.repsitory.RoomJpaRepository;
import com.maneater.foundation.vo.Result;
import com.maneater.foundation.vo.ViewPosition;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2015/11/19 0019.
 * 房间
 */
@Service
public class RoomService {

    @Resource
    private RoomJpaRepository roomJpaRepository;

    @Resource
    private ProductCategoryJpaRepository productCategoryJpaRepository;

    @Resource
    private ProductCategoryPositionRepository productCategoryPositionRepository;

    public List<Room> listByCategoryId(String categoryId) {
        return roomJpaRepository.findByCategoryId(categoryId);
    }

    public Room findById(String id) {
        return roomJpaRepository.findOne(id);
    }

//    //后台用，查出所有可用分类，如果该分类有位置信息，则附加进去
//    public void attachPositionList(Room room) {
//        room.setProductCategoryList(findPositionByRoomId(room.getId()));
//    }

    public List<ProductCategoryPosition> findPositionListByRoomId(String id) {
        //只列举有效的类型
        List<ProductCategory> productCategoryList = productCategoryJpaRepository.findByEnable(true);
        List<ProductCategoryPosition> positionList = productCategoryPositionRepository.findByRoomId(id);
        if (positionList != null) {
            for (int i = 0; i < positionList.size(); i++) {
                ProductCategoryPosition position = positionList.get(i);
                position.setCreateTime(null);
                position.setName(null);
                position.setLastUpdateTime(null);
                ProductCategory category = getCategory(position, productCategoryList);
                if (category != null) {
                    category.setProductCategoryPosition(null);
                    category.setExpandPropertyList(null);
                    position.setCreateTime(null);
                    position.setLastUpdateTime(null);
                    position.setProductCategory(category);
                } else {
                    //如果该分类无效，则踢出掉
                    positionList.remove(i);
                    i--;
                }
            }
        }
        return positionList;
    }

    private ProductCategory getCategory(ProductCategoryPosition position, List<ProductCategory> productCategoryList) {
        if (productCategoryList != null) {
            for (ProductCategory category : productCategoryList) {
                //在有效中
                if (category.getId().equals(position.getProductCategoryId())) {
                    return category;
                }
            }
        }
        return null;
    }

//    public List<ProductCategory> findPositionByRoomId(String roomId) {
//        //只出现有效的
//        List<ProductCategory> productCategoryList = productCategoryJpaRepository.findByEnable(true);
//        if (!CollectionUtils.isEmpty(productCategoryList)) {
//            for (ProductCategory productCategory : productCategoryList) {
//                productCategory.setProductCategoryPosition(productCategoryPositionRepository.findByRoomIdAndProductCategoryId(roomId, productCategory.getId()));
//            }
//        }
//        return productCategoryList;
//    }

    public List<Room> lisAll() {
        return roomJpaRepository.findAll();
    }

    public List<Room> listAllByEnable(boolean enable) {
        return roomJpaRepository.findByEnable(enable);
    }

    public Room save(Room room) {
        return roomJpaRepository.save(room);
    }

    public boolean changeEnable(String id, boolean enable) {
        return roomJpaRepository.setEnableStatus(id, enable) > 0;
    }


    //批量保存位置信息，先清空之前的所有信息，然后重新保存
    public Result saveRoomPositions(ViewPosition viewPosition) {
        Room room = roomJpaRepository.findOne(viewPosition.getRoomId());
        if (room != null) {
            productCategoryPositionRepository.deleteByRoomId(viewPosition.getRoomId());
            if (viewPosition.getPositions() != null && viewPosition.getPositions().length > 0) {

                //更新room效果背景图
                room.setEffectPicUrl(viewPosition.getBgPicUrl());
                roomJpaRepository.save(room);

                for (ProductCategoryPosition position : viewPosition.getPositions()) {
                    if (!StringUtils.isEmpty(position.getProductCategoryId())) {
                        position.setRoomId(room.getId());
                        productCategoryPositionRepository.save(position);
                    }
                }
            }
        } else {
            return Result.result(0, "room error", null);
        }
        return Result.result(1, "success", null);
    }

}
