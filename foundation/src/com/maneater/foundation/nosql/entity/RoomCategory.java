package com.maneater.foundation.nosql.entity;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class RoomCategory extends BaseEntity {
    private String picUrl;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
