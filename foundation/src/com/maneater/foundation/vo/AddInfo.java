package com.maneater.foundation.vo;

/**
 * Created by liang on 15/12/20.
 */
public class AddInfo {

    public AddInfo() {
    }

    private String productCode;
    private int qyt;

    public int getQyt() {
        return qyt;
    }

    public void setQyt(int qyt) {
        this.qyt = qyt;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
