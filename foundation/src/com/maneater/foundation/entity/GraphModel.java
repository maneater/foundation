package com.maneater.foundation.entity;

import com.maneater.foundation.uitl.ZipPropertiesUtil;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2015/11/18 0018.
 */

/**
 * 家具
 */
@Entity
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Table(name = "t_graph_model")
public class GraphModel extends BaseEntity {
/*
    id#466=Kator Legaz#concept-sedan-01v1#CarNew
    name#466=Concept Sedan 01 CarNew
    tags#466=CarNew
    creationDate#466=2008-04-29
    category#466=CarNew
    icon#466=katorlegaz/concept-sedan-01v1.png
    iconDigest#466=STHV0BYEHZJouqv0bfqjuYbXoJM=
    model#466=katorlegaz/concept-sedan-01v1.zip!/concept-sedan-01v1.obj
    modelDigest#466=MFKeroUSTCrxXZxuVU8vqaRxBdw=
    multiPartModel#466=true
    width#466=191.1
    depth#466=471.1
    height#466=155.0
    movable#466=true
    doorOrWindow#466=false
    creator#466=Kator Legaz*/

    @Column(nullable = false)
    private Long categoryId;
    @Column(nullable = false)
    private String categoryName;

    @Column(unique = true, nullable = false)
    private String sequenceName;
    @Column(nullable = false)
    private String tags;
    @Column(nullable = false)
    private String icon;
    @Column(nullable = false)
    private String iconDigest;
    private String model;
    private String modelDigest;
    private Double width;
    private Double depth;
    private Double height;
    private Double dropOnTopElevation;
    @Column(nullable = true, columnDefinition = "int default 0")
    private boolean multiPartModel;
    @Column(nullable = true, columnDefinition = "int default 1")
    private boolean movable;
    @Column(nullable = true, columnDefinition = "int default 0")
    private boolean doorOrWindow;

    /*@Transient表示该属性并非一个到数据库表的字段的映射,ORM框架将忽略该属性*/

    private Long supplierId;
    private String supplierName;


    private String qyt;
    private String code;

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getQyt() {
        return qyt;
    }

    public void setQyt(String qyt) {
        this.qyt = qyt;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getSequenceName() {
        return sequenceName;
    }

    public Double getDropOnTopElevation() {
        return dropOnTopElevation;
    }

    public void setDropOnTopElevation(Double dropOnTopElevation) {
        this.dropOnTopElevation = dropOnTopElevation;
    }

    public void setSequenceName(String sequenceName) {
        this.sequenceName = sequenceName;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }

    public boolean isDoorOrWindow() {
        return doorOrWindow;
    }

    public void setDoorOrWindow(boolean doorOrWindow) {
        this.doorOrWindow = doorOrWindow;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getIcon() {
        return icon;
    }

    public String getIconPath(String appPath) {
        return ZipPropertiesUtil.getPathLocation(appPath, this.getIcon());
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIconDigest() {
        return iconDigest;
    }

    public void setIconDigest(String iconDigest) {
        this.iconDigest = iconDigest;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModelDigest() {
        return modelDigest;
    }

    public void setModelDigest(String modelDigest) {
        this.modelDigest = modelDigest;
    }

    public boolean isMovable() {
        return movable;
    }

    public void setMovable(boolean movable) {
        this.movable = movable;
    }

    public boolean isMultiPartModel() {
        return multiPartModel;
    }

    public void setMultiPartModel(boolean multiPartModel) {
        this.multiPartModel = multiPartModel;
    }


    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }
}
