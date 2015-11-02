package com.yikangyiliao.pension.entity;

public class ServiceNote {
    private Long serviceNoteId;

    private String title;

    private String content;

    private Long createTime;

    private Long updateTime;

    private Byte orderNumber;

    public Long getServiceNoteId() {
        return serviceNoteId;
    }

    public void setServiceNoteId(Long serviceNoteId) {
        this.serviceNoteId = serviceNoteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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

    public Byte getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Byte orderNumber) {
        this.orderNumber = orderNumber;
    }
}