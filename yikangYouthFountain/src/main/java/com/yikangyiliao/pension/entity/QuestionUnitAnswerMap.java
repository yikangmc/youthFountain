package com.yikangyiliao.pension.entity;

public class QuestionUnitAnswerMap {
    private Long questionCrosswisePortraitAnswerId;

    private Long answerId;

    private Long questionPortraitGroup;

    private Long questionCrosswiseGroup;

    private Byte isDelete;

    private Byte answerType;

    public Long getQuestionCrosswisePortraitAnswerId() {
        return questionCrosswisePortraitAnswerId;
    }

    public void setQuestionCrosswisePortraitAnswerId(Long questionCrosswisePortraitAnswerId) {
        this.questionCrosswisePortraitAnswerId = questionCrosswisePortraitAnswerId;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public Long getQuestionPortraitGroup() {
        return questionPortraitGroup;
    }

    public void setQuestionPortraitGroup(Long questionPortraitGroup) {
        this.questionPortraitGroup = questionPortraitGroup;
    }

    public Long getQuestionCrosswiseGroup() {
        return questionCrosswiseGroup;
    }

    public void setQuestionCrosswiseGroup(Long questionCrosswiseGroup) {
        this.questionCrosswiseGroup = questionCrosswiseGroup;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Byte getAnswerType() {
        return answerType;
    }

    public void setAnswerType(Byte answerType) {
        this.answerType = answerType;
    }
}