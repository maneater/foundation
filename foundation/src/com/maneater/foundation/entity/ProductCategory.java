//package com.maneater.foundation.entity;
//
//import org.codehaus.jackson.map.annotate.JsonSerialize;
//
//import javax.persistence.*;
//import java.util.List;
//
///**
// * Created by Administrator on 2015/11/19 0019.
// */
//@Entity
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@Table(name = "t_product_category")
//public class ProductCategory extends BaseEntity {
//    private String picUrl;
//
//    public String getPicUrl() {
//        return picUrl;
//    }
//
//    public void setPicUrl(String picUrl) {
//        this.picUrl = picUrl;
//    }
//
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "productCategory")
//    private List<ExpandProperty> expandPropertyList = null;
//
//    public List<ExpandProperty> getExpandPropertyList() {
//        return expandPropertyList;
//    }
//
//    public void setExpandPropertyList(List<ExpandProperty> expandPropertyList) {
//        this.expandPropertyList = expandPropertyList;
//    }
//}
