package com.maneater.foundation.vo;

import com.maneater.foundation.nosql.entity.ProductCategoryPosition;

/**
 * Created by liang on 15/12/27.
 */
public class ViewPosition {
    private String roomId;
    private ProductCategoryPosition[] positions;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public ProductCategoryPosition[] getPositions() {
        return positions;
    }

    public void setPositions(ProductCategoryPosition[] positions) {
        this.positions = positions;
    }
}
