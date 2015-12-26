package com.maneater.foundation.nosql.entity;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Table;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Document
@Table(name = "t_admin")
@Entity
public class Admin extends BaseEntity {

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
