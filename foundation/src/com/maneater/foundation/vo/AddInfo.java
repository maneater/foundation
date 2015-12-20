package com.maneater.foundation.vo;

/**
 * Created by liang on 15/12/20.
 */
public class AddInfo {

    private String productCode;
    private int qyt;
    private int checked = 0;

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

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
