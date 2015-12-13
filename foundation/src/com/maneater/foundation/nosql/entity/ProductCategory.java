package com.maneater.foundation.nosql.entity;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ProductCategory extends BaseEntity {
    private String picUrl;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    private List<ExpandProperty> expandPropertyList = null;

    public List<ExpandProperty> getExpandPropertyList() {
        return expandPropertyList;
    }

    public void setExpandPropertyList(List<ExpandProperty> expandPropertyList) {
        this.expandPropertyList = expandPropertyList;
    }
}
