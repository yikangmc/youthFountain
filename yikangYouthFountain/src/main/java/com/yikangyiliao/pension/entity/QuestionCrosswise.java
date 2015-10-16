package com.yikangyiliao.pension.entity;

import java.util.List;
import java.util.Map;

public class QuestionCrosswise {
    private Long questionCrosswiseId;

    private String questionCrosswiseName;

    private Long createTime;

    private Long updateTime;

    private Long createUserId;

    private Byte isDelete;

    private Long surveyTableId;

    private Byte answerType;
    
    private List<Map<String,Object>> questions;

    public Long getQuestionCrosswiseId() {
        return questionCrosswiseId;
    }

    public void setQuestionCrosswiseId(Long questionCrosswiseId) {
        this.questionCrosswiseId = questionCrosswiseId;
    }

    public String getQuestionCrosswiseName() {
        return questionCrosswiseName;
    }

    public void setQuestionCrosswiseName(String questionCrosswiseName) {
        this.questionCrosswiseName = questionCrosswiseName == null ? null : questionCrosswiseName.trim();
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

    public Long getSurveyTableId() {
        return surveyTableId;
    }

    public void setSurveyTableId(Long surveyTableId) {
        this.surveyTableId = surveyTableId;
    }

    public Byte getAnswerType() {
        return answerType;
    }

    public void setAnswerType(Byte answerType) {
        this.answerType = answerType;
    }

	public List<Map<String, Object>> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Map<String, Object>> questions) {
		this.questions = questions;
	}
}