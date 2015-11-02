package com.yikangyiliao.pension.entity;

public class MedicinalApparatu {
    private Long medicinalApparatuId;

    private String maName;

    private String price;

    private Long createTime;

    private Byte outOfStock;

    private Long updateTime;

    private String picUrl;

    public Long getMedicinalApparatuId() {
        return medicinalApparatuId;
    }

    public void setMedicinalApparatuId(Long medicinalApparatuId) {
        this.medicinalApparatuId = medicinalApparatuId;
    }

    public String getMaName() {
        return maName;
    }

    public void setMaName(String maName) {
        this.maName = maName == null ? null : maName.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Byte getOutOfStock() {
        return outOfStock;
    }

    public void setOutOfStock(Byte outOfStock) {
        this.outOfStock = outOfStock;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }
}