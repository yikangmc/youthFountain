package com.yikangyiliao.pension.entity;

public class QuestionUnitWeight {
    private Long questionUnitWeightId;

    private String questionPortraitId;

    private String weightValue;

    private Long createTime;

    private Long updateTime;

    private String createUserId;

    public Long getQuestionUnitWeightId() {
        return questionUnitWeightId;
    }

    public void setQuestionUnitWeightId(Long questionUnitWeightId) {
        this.questionUnitWeightId = questionUnitWeightId;
    }

    public String getQuestionPortraitId() {
        return questionPortraitId;
    }

    public void setQuestionPortraitId(String questionPortraitId) {
        this.questionPortraitId = questionPortraitId == null ? null : questionPortraitId.trim();
    }

    public String getWeightValue() {
        return weightValue;
    }

    public void setWeightValue(String weightValue) {
        this.weightValue = weightValue == null ? null : weightValue.trim();
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

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }
}