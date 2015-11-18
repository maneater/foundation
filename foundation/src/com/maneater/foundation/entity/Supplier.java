package com.maneater.foundation.entity;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2015/11/18 0018.
 */
@Entity
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Table(name = "t_supplier")
public class Supplier extends BaseEntity {
    private String name;
    private String info;

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
}
