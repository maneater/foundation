package com.maneater.foundation.nosql.entity;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Administrator on 2015/11/18 0018.
 */
@Document
@Entity
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Table(name = "t_product")
public class Product extends BaseEntity {

    @Column(nullable = false)
    private String categoryId;
    @Column(nullable = false)
    private String categoryName;

    //基础产品code
    @Column(nullable = false, unique = true)
    private String code;

    @Column(length = 2000)
    private String thumbnailPicture;
    @Column(length = 2000)
    private String detailPicture;

    @Column(length = 2000)
    private String descBasic;
    @Column(length = 2000)
    private String descDetail;


    @Column(length = 2000)
    /***  绘图里用 */
    private String effectPicUrl;

    //基础size
    private String width;
    private String depth;
    private String height;
    private String sizeUnit;

    private Double price;

    //属性产品，对应与产品详情里的
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
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

    public String getEffectPicUrl() {
        return effectPicUrl;
    }

    public void setEffectPicUrl(String effectPicUrl) {
        this.effectPicUrl = effectPicUrl;
    }


    /**
     * @param productCode
     * @return
     */
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

    /**
     * 获取指定code的产品效果图，绘图里用
     *
     * @param productCode
     * @return
     */
    public String getEffectPicUrlByCode(String productCode) {
        String effectPicUrl = this.effectPicUrl;
        if (!productCode.equals(this.code) && this.propertyProductList != null) {
            for (PropertyProduct propertyProduct : this.propertyProductList) {
                if (propertyProduct.equals(propertyProduct)) {
                    return propertyProduct.getEffectPicUrl();
                }
            }
        }
        return effectPicUrl;
    }


    /**
     * 获取指定code的产品详情图
     *
     * @param productCode
     * @return
     */
    public String getDetailPictureByCode(String productCode) {
        String detailPicture = this.detailPicture;
        if (!productCode.equals(this.code) && this.propertyProductList != null) {
            for (PropertyProduct propertyProduct : this.propertyProductList) {
                if (propertyProduct.equals(propertyProduct)) {
                    return propertyProduct.getProductPicUrl();
                }
            }
        }
        return detailPicture;
    }
}
