package com.yikangyiliao.pension.entity;

public class ServiceItemOwnServicerType {
    private Long serviceItemOwnServicerTypeId;

    private Long serviceItemId;

    private Integer servicerType;

    private Long createTime;

    private Long updateTime;

    private Long createUserId;

    public Long getServiceItemOwnServicerTypeId() {
        return serviceItemOwnServicerTypeId;
    }

    public void setServiceItemOwnServicerTypeId(Long serviceItemOwnServicerTypeId) {
        this.serviceItemOwnServicerTypeId = serviceItemOwnServicerTypeId;
    }

    public Long getServiceItemId() {
        return serviceItemId;
    }

    public void setServiceItemId(Long serviceItemId) {
        this.serviceItemId = serviceItemId;
    }

    public Integer getServicerType() {
        return servicerType;
    }

    public void setServicerType(Integer servicerType) {
        this.servicerType = servicerType;
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
}