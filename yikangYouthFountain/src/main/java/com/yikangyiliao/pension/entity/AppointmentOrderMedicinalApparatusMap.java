package com.yikangyiliao.pension.entity;

public class AppointmentOrderMedicinalApparatusMap {
    private Long appointmentOrderMedicinalApparatuMapId;

    private Long appointmentOrderId;

    private Long orderServiceDetailId;

    private Long createTime;

    private Long updateTime;

    private Long medicinalApparatusId;

    public Long getAppointmentOrderMedicinalApparatuMapId() {
        return appointmentOrderMedicinalApparatuMapId;
    }

    public void setAppointmentOrderMedicinalApparatuMapId(Long appointmentOrderMedicinalApparatuMapId) {
        this.appointmentOrderMedicinalApparatuMapId = appointmentOrderMedicinalApparatuMapId;
    }

    public Long getAppointmentOrderId() {
        return appointmentOrderId;
    }

    public void setAppointmentOrderId(Long appointmentOrderId) {
        this.appointmentOrderId = appointmentOrderId;
    }

    public Long getOrderServiceDetailId() {
        return orderServiceDetailId;
    }

    public void setOrderServiceDetailId(Long orderServiceDetailId) {
        this.orderServiceDetailId = orderServiceDetailId;
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

    public Long getMedicinalApparatusId() {
        return medicinalApparatusId;
    }

    public void setMedicinalApparatusId(Long medicinalApparatusId) {
        this.medicinalApparatusId = medicinalApparatusId;
    }
}