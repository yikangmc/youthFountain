
package com.yikangyiliao.pension.dao;

import com.yikangyiliao.pension.entity.ServicePicture;

public interface ServicePictureDao {
    int deleteByPrimaryKey(Long servicePictureId);

    int insert(ServicePicture record);

    int insertSelective(ServicePicture record);

    ServicePicture selectByPrimaryKey(Long servicePictureId);

    int updateByPrimaryKeySelective(ServicePicture record);

    int updateByPrimaryKey(ServicePicture record);
    
   // List<Service>
}