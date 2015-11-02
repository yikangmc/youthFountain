package com.yikangyiliao.pension.entity;

public class ServicePicture {
    private Long servicePictureId;

    private String picUrl;

    private Long createTime;

    private Long updateTime;

    private Long serviceItemId;

    public Long getServicePictureId() {
        return servicePictureId;
    }

    public void setServicePictureId(Long servicePictureId) {
        this.servicePictureId = servicePictureId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
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

    public Long getServiceItemId() {
        return serviceItemId;
    }

    public void setServiceItemId(Long serviceItemId) {
        this.serviceItemId = serviceItemId;
    }
}