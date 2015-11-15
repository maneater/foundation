package com.maneater.foundation.entity;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by macbook on 15/11/13.
 */
@Entity
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Table(name = "t_category")
public class Category extends BaseEntity {
    private String name;
    private String info;
    /**
     * 0=product;1=pics;2=urls;
     */
    private int type;
    private long orderNum;
    private String picUrl;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(long orderNum) {
        this.orderNum = orderNum;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}