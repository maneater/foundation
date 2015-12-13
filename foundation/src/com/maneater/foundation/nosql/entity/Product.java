package com.maneater.foundation.nosql.entity;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.persistence.Column;
import java.util.List;

/**
 * Created by Administrator on 2015/11/18 0018.
 */

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Product extends BaseEntity {

    @Column(nullable = false)
    private String categoryId;
    @Column(nullable = false)
    private String categoryName;


    //基础产品code
    @Column(nullable = false)
    private String code;

    private String thumbnailPicture;
    private String detailPicture;

    private String descBasic;
    private String descDetail;

    //基础size
    private String width;
    private String depth;
    private String height;
    private String sizeUnit;

    private Double price;

    private List<PropertyProduct> propertyProductList = null;

    public List<PropertyProduct> getPropertyProductList() {
        return propertyProductList;
    }

    public void setPropertyProductList(List<PropertyProduct> propertyProductList) {
        this.propertyProductList = propertyProductList;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getThumbnailPicture() {
        return thumbnailPicture;
    }

    public void setThumbnailPicture(String thumbnailPicture) {
        this.thumbnailPicture = thumbnailPicture;
    }

    public String getDetailPicture() {
        return detailPicture;
    }

    public void setDetailPicture(String detailPicture) {
        this.detailPicture = detailPicture;
    }

    public String getDescBasic() {
        return descBasic;
    }

    public void setDescBasic(String descBasic) {
        this.descBasic = descBasic;
    }

    public String getDescDetail() {
        return descDetail;
    }

    public void setDescDetail(String descDetail) {
        this.descDetail = descDetail;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getSizeUnit() {
        return sizeUnit;
    }

    public void setSizeUnit(String sizeUnit) {
        this.sizeUnit = sizeUnit;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPriceByCode(String productCode) {
        if (productCode.equals(this.code)) {
            return this.price;
        } else if (this.propertyProductList != null) {
            for (PropertyProduct propertyProduct : this.propertyProductList) {
                if (propertyProduct.equals(propertyProduct)) {
                    return propertyProduct.getProductPrice();
                }
            }
        }
        return this.price;
    }
}
