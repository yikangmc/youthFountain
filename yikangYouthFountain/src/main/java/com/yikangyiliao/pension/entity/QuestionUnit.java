package com.yikangyiliao.pension.entity;

public class QuestionUnit {
    private Long questionPortraitId;

    private String questionPortraitName;

    private Long createTime;

    private Long updateTime;

    private Long createUserId;

    private Byte isDelete;

    private Byte order;

    private Long surveyTableId;

    private Long questionCrosswiseId;

    private Byte answerType;

    public Long getQuestionPortraitId() {
        return questionPortraitId;
    }

    public void setQuestionPortraitId(Long questionPortraitId) {
        this.questionPortraitId = questionPortraitId;
    }

    public String getQuestionPortraitName() {
        return questionPortraitName;
    }

    public void setQuestionPortraitName(String questionPortraitName) {
        this.questionPortraitName = questionPortraitName == null ? null : questionPortraitName.trim();
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

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Byte getOrder() {
        return order;
    }

    public void setOrder(Byte order) {
        this.order = order;
    }

    public Long getSurveyTableId() {
        return surveyTableId;
    }

    public void setSurveyTableId(Long surveyTableId) {
        this.surveyTableId = surveyTableId;
    }

    public Long getQuestionCrosswiseId() {
        return questionCrosswiseId;
    }

    public void setQuestionCrosswiseId(Long questionCrosswiseId) {
        this.questionCrosswiseId = questionCrosswiseId;
    }

    public Byte getAnswerType() {
        return answerType;
    }

    public void setAnswerType(Byte answerType) {
        this.answerType = answerType;
    }
}