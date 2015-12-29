package com.maneater.foundation.nosql.entity;


import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Document
@Entity
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Table(name = "t_product_category_position")
public class ProductCategoryPosition extends BaseEntity {

    public ProductCategoryPosition() {
        this.name = "defaultName";
    }

    @Column(nullable = false)
    private String roomId;
    @Column(nullable = false)
    private String productCategoryId;

    @Column(nullable = false)
    private String x = "0";
    @Column(nullable = false)
    private String y = "0";
    @Column(nullable = false)
    private String zIndex = "0";

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(String productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getzIndex() {
        return zIndex;
    }

    public void setzIndex(String zIndex) {
        this.zIndex = zIndex;
    }
}
