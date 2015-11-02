package com.yikangyiliao.pension.entity;

public class ServiceItemMedicinalApparatusMap {
    private Long serviceItemMedicinalApparatusMapId;

    private Long serviceItemId;

    private Long medicinalApparatusId;

    private Long createTime;

    private Long updateTime;

    public Long getServiceItemMedicinalApparatusMapId() {
        return serviceItemMedicinalApparatusMapId;
    }

    public void setServiceItemMedicinalApparatusMapId(Long serviceItemMedicinalApparatusMapId) {
        this.serviceItemMedicinalApparatusMapId = serviceItemMedicinalApparatusMapId;
    }

    public Long getServiceItemId() {
        return serviceItemId;
    }

    public void setServiceItemId(Long serviceItemId) {
        this.serviceItemId = serviceItemId;
    }

    public Long getMedicinalApparatusId() {
        return medicinalApparatusId;
    }

    public void setMedicinalApparatusId(Long medicinalApparatusId) {
        this.medicinalApparatusId = medicinalApparatusId;
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
}