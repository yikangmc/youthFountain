package com.yikangyiliao.pension.entity;

public class QuestionSurveyMap {
    private Long questionSurveyId;

    private Long questionId;

    private Long surveyId;

    private Long createTime;

    private Long updateTime;

    private Byte dataSource;

    private Byte isDelete;

    public Long getQuestionSurveyId() {
        return questionSurveyId;
    }

    public void setQuestionSurveyId(Long questionSurveyId) {
        this.questionSurveyId = questionSurveyId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
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

    public Byte getDataSource() {
        return dataSource;
    }

    public void setDataSource(Byte dataSource) {
        this.dataSource = dataSource;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}