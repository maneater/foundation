package com.maneater.foundation.nosql.entity;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Document
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Table(name = "t_room")
@Entity
public class Room extends BaseEntity {
    private String picUrl;
    private String categoryId;
    private String categoryName;
    private Integer roomsNumber;
    private String effectPicUrl;

    public String getEffectPicUrl() {
        return effectPicUrl;
    }

    public void setEffectPicUrl(String effectPicUrl) {
        this.effectPicUrl = effectPicUrl;
    }

    public Integer getRoomsNumber() {
        return roomsNumber;
    }

    public void setRoomsNumber(Integer roomsNumber) {
        this.roomsNumber = roomsNumber;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @Transient
    //包含所有产品分类，但是有的分类包含position 有的分类不包含position
    private List<ProductCategory> productCategoryList = null;

    public List<ProductCategory> getProductCategoryList() {
        return productCategoryList;
    }

    public void setProductCategoryList(List<ProductCategory> productCategoryList) {
        this.productCategoryList = productCategoryList;
    }
}
