//package com.maneater.foundation.entity;
//
//import org.codehaus.jackson.map.annotate.JsonSerialize;
//
//import javax.persistence.*;
//
///**
// * Created by liang on 15/12/5.
// */
//
//@Entity
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@Table(name = "t_expand_property")
//public class ExpandProperty extends BaseEntity {
//
//    // optional=true：可选，表示此对象可以没有，可以为null；false表示必须存在
//    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE}, optional = true)
//    @JoinColumn(name = "product_category_id")
//    private ProductCategory productCategory;
//
//    /**
//     * title=value;title=value;....
//     */
//    private String defaultOptions;
//
//
//    public String getDefaultOptions() {
//        return defaultOptions;
//    }
//
//    public void setDefaultOptions(String defaultOptions) {
//        this.defaultOptions = defaultOptions;
//    }
//}
