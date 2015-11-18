package com.maneater.foundation.entity;

/**
 * Created by Administrator on 2015/11/18 0018.
 */
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

    private String name;
    private String tags;
    private String category;
    private String icon;
    private String iconDigest;
    private String model;
    private String modelDigest;
    private boolean multiPartModel;
    private Double width;
    private Double depth;
    private Double height;
    private boolean movable;
    private boolean doorOrWindow;

    private long supplierId;
    private String supplierName;



    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
