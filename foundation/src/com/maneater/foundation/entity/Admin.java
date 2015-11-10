package com.maneater.foundation.entity;

import javax.persistence.*;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@Entity
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Table(name = "t_admin")
public class Admin extends BaseEntity {

    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
