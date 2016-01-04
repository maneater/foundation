package com.maneater.foundation.nosql.entity;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Document
@Table(name = "t_order_item")
@Entity
public class OrderItem extends BaseEntity {

    public OrderItem() {
        this.name = "defaultName";
    }

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id")
    private OrderInfo orderInfo;
    private String productCode;
    private int qyt;
    //入库时价格
    private double price;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getQyt() {
        return qyt;
    }

    public void setQyt(int qyt) {
        this.qyt = qyt;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    @Transient
//    private Product product = null;
    @Transient
    private PropertyProduct propertyProduct = null;

    public PropertyProduct getPropertyProduct() {
        return propertyProduct;
    }

    public void setPropertyProduct(PropertyProduct propertyProduct) {
        this.propertyProduct = propertyProduct;
    }

//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }
}
