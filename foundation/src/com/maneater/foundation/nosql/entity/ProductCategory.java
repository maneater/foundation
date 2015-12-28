package com.maneater.foundation.nosql.entity;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.List;

@Document
@Entity
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Table(name = "t_product_category")
public class ProductCategory extends BaseEntity {
    private String picUrl;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "productCategory")
    private List<ExpandProperty> expandPropertyList = null;

    public List<ExpandProperty> getExpandPropertyList() {
        return expandPropertyList;
    }

    public void setExpandPropertyList(List<ExpandProperty> expandPropertyList) {
        this.expandPropertyList = expandPropertyList;
    }

    @Transient
    private ProductCategoryPosition productCategoryPosition = null;

    public void setProductCategoryPosition(ProductCategoryPosition productCategoryPosition) {
        this.productCategoryPosition = productCategoryPosition;
    }

    public ProductCategoryPosition getProductCategoryPosition() {
        return productCategoryPosition;
    }
}
