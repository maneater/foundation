package com.maneater.foundation.nosql.entity;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "int")
    protected String id;
    @Column(nullable = false)
    protected String name;
    @Column(length = 500)
    protected String info;
    protected boolean enable = true;
    protected long orderNum;
    @Column(nullable = false)
    protected java.util.Date lastUpdateTime;
    @Column(nullable = false)
    protected java.util.Date createTime;

    public java.util.Date getCreateTime() {
        return createTime;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public java.util.Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(java.util.Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getOrderNum() {
        return orderNum;
    }

    @PrePersist
    public void prePersist() {
        long nowTime = System.currentTimeMillis();
        this.lastUpdateTime = new java.util.Date(nowTime);
        this.createTime = new java.util.Date(nowTime);
    }

    @PreUpdate
    public void preUpdate() {
        long nowTime = System.currentTimeMillis();
        this.lastUpdateTime = new java.util.Date(nowTime);
        if (this.createTime == null) {
            this.createTime = new java.util.Date(nowTime);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOrderNum(long orderNum) {
        this.orderNum = orderNum;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
