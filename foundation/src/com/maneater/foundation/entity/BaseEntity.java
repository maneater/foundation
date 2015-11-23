package com.maneater.foundation.entity;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.persistence.*;
import java.sql.Date;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(nullable = false)
    protected String name;
    protected String info;
    protected boolean enable = true;
    protected long orderNum;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    protected java.util.Date lastUpdateTime;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    protected java.util.Date createTime;

    public java.util.Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
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

    public void setOrderNum(long orderNum) {
        this.orderNum = orderNum;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                '}';
    }
}
