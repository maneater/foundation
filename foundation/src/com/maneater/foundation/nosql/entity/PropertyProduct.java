package com.maneater.foundation.nosql.entity;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Document
@Entity
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Table(name = "t_property_product")
public class PropertyProduct extends BaseEntity {

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(nullable = false)
    private String propertyName;
    @Column(nullable = false)
    private String propertyValue;
    private String propertyInfo;
    //属性介绍缩略图，例如 颜色块块图，纹理块图
    private String propertyPicUrl;

    //属性产品对应的效果图，与Product 里 effectPicUrl对等
    @Column(length = 2000)
    private String effectPicUrl;

    @Column(nullable = false, unique = true)
    private String productCode;
    //属性产品对应的详情图，与Product 里 detailPicture对等
    private String productPicUrl;
    @Column(nullable = false)
    private Double productPrice;

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyInfo() {
        return propertyInfo;
    }

    public void setPropertyInfo(String propertyInfo) {
        this.propertyInfo = propertyInfo;
    }

    public String getPropertyPicUrl() {
        return propertyPicUrl;
    }

    public void setPropertyPicUrl(String propertyPicUrl) {
        this.propertyPicUrl = propertyPicUrl;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductPicUrl() {
        return productPicUrl;
    }

    public void setProductPicUrl(String productPicUrl) {
        this.productPicUrl = productPicUrl;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getEffectPicUrl() {
        return effectPicUrl;
    }

    public void setEffectPicUrl(String effectPicUrl) {
        this.effectPicUrl = effectPicUrl;
    }
}
