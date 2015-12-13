//package com.maneater.foundation.entity;
//
//import com.maneater.foundation.uitl.ZipPropertiesUtil;
//import org.codehaus.jackson.map.annotate.JsonSerialize;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//
///**
// * Created by Administrator on 2015/11/18 0018.
// */
//
///**
// * 家具
// */
//@Entity
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@Table(name = "t_product")
//public class Product extends BaseEntity {
//
//    @Column(nullable = false)
//    private Long categoryId;
//    @Column(nullable = false)
//    private String categoryName;
//
//
//    //基础产品code
//    @Column(nullable = false)
//    private String code;
//
//    private String thumbnailPicture;
//    private String detailPicture;
//
//    private String descBisic;
//    private String descDetail;
//
//    //基础size
//    private String width;
//    private String depth;
//    private String height;
//    private String sizeUnit;
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public String getThumbnailPicture() {
//        return thumbnailPicture;
//    }
//
//    public void setThumbnailPicture(String thumbnailPicture) {
//        this.thumbnailPicture = thumbnailPicture;
//    }
//
//    public String getDetailPicture() {
//        return detailPicture;
//    }
//
//    public void setDetailPicture(String detailPicture) {
//        this.detailPicture = detailPicture;
//    }
//
//    public String getDescBisic() {
//        return descBisic;
//    }
//
//    public void setDescBisic(String descBisic) {
//        this.descBisic = descBisic;
//    }
//
//    public String getDescDetail() {
//        return descDetail;
//    }
//
//    public void setDescDetail(String descDetail) {
//        this.descDetail = descDetail;
//    }
//
//    public String getWidth() {
//        return width;
//    }
//
//    public void setWidth(String width) {
//        this.width = width;
//    }
//
//    public String getDepth() {
//        return depth;
//    }
//
//    public void setDepth(String depth) {
//        this.depth = depth;
//    }
//
//    public String getHeight() {
//        return height;
//    }
//
//    public void setHeight(String height) {
//        this.height = height;
//    }
//
//    public String getSizeUnit() {
//        return sizeUnit;
//    }
//
//    public void setSizeUnit(String sizeUnit) {
//        this.sizeUnit = sizeUnit;
//    }
//
//    public Long getCategoryId() {
//        return categoryId;
//    }
//
//    public void setCategoryId(Long categoryId) {
//        this.categoryId = categoryId;
//    }
//
//    public String getCategoryName() {
//        return categoryName;
//    }
//
//    public void setCategoryName(String categoryName) {
//        this.categoryName = categoryName;
//    }
//}
