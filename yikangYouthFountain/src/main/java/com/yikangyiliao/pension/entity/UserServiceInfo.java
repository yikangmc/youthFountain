package com.yikangyiliao.pension.entity;

public class UserServiceInfo {
    private Long userServiceInfoId;

    private Long userId;

    private Long jobCategory;

    private Long userPostion;

    private Long provenceCode;

    private Long cityCode;

    private Long districtCode;

    private String addressDetail;

    private String photoUrl;

    private Long createTime;

    private Long updateTime;

    private Byte isDelete;

    private String userServiceName;

    private Double longitude;

    private Double latitude;

    public Long getUserServiceInfoId() {
        return userServiceInfoId;
    }

    public void setUserServiceInfoId(Long userServiceInfoId) {
        this.userServiceInfoId = userServiceInfoId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(Long jobCategory) {
        this.jobCategory = jobCategory;
    }

    public Long getUserPostion() {
        return userPostion;
    }

    public void setUserPostion(Long userPostion) {
        this.userPostion = userPostion;
    }

    public Long getProvenceCode() {
        return provenceCode;
    }

    public void setProvenceCode(Long provenceCode) {
        this.provenceCode = provenceCode;
    }

    public Long getCityCode() {
        return cityCode;
    }

    public void setCityCode(Long cityCode) {
        this.cityCode = cityCode;
    }

    public Long getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(Long districtCode) {
        this.districtCode = districtCode;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail == null ? null : addressDetail.trim();
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
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

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public String getUserServiceName() {
        return userServiceName;
    }

    public void setUserServiceName(String userServiceName) {
        this.userServiceName = userServiceName == null ? null : userServiceName.trim();
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}