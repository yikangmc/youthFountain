package com.yikangyiliao.pension.entity;

public class ServiceItem {
    private Long serviceItemId;

    private String serviceTitle;

    private String serviceContent;

    private Long createTime;

    private Long updateTime;

    private Long createUserId;

    private Float servicePrice;

    private Byte outOfStock;

    private String picUrl;

    private Integer orderNumber;

    private Integer serviceTime;

    private String webPicUrl;

    public Long getServiceItemId() {
        return serviceItemId;
    }

    public void setServiceItemId(Long serviceItemId) {
        this.serviceItemId = serviceItemId;
    }

    public String getServiceTitle() {
        return serviceTitle;
    }

    public void setServiceTitle(String serviceTitle) { 
        this.serviceTitle = serviceTitle == null ? null : serviceTitle.trim();
    }

    public String getServiceContent() {
        return serviceContent;
    }

    public void setServiceContent(String serviceContent) {
        this.serviceContent = serviceContent == null ? null : serviceContent.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Float getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(Float servicePrice) {
        this.servicePrice = servicePrice;
    }

    public Byte getOutOfStock() {
        return outOfStock;
    }

    public void setOutOfStock(Byte outOfStock) {
        this.outOfStock = outOfStock;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(Integer serviceTime) {
        this.serviceTime = serviceTime;
    }

    public String getWebPicUrl() {
        return webPicUrl;
    }

    public void setWebPicUrl(String webPicUrl) {
        this.webPicUrl = webPicUrl == null ? null : webPicUrl.trim();
    }
}