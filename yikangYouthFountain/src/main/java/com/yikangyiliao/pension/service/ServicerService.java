package com.yikangyiliao.pension.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yikangyiliao.pension.common.error.ExceptionConstants;
import com.yikangyiliao.pension.common.utils.map.MapUtils;
import com.yikangyiliao.pension.common.utils.map.model.MapResponse;
import com.yikangyiliao.pension.entity.Location;
import com.yikangyiliao.pension.entity.UserServiceInfo;
import com.yikangyiliao.pension.logic.ServicerBusinessLogic;
import com.yikangyiliao.pension.manager.LocationManager;
import com.yikangyiliao.pension.manager.ServiceItemOwnServicerTypeManager;
import com.yikangyiliao.pension.manager.TimeQuantumManager;
import com.yikangyiliao.pension.manager.UserManager;

/**
 * @author liushuaic
 * @date 2015/10/14 19:11
 * @desc 服务人员service
 * 
 * 
 **/

@Service(value = "servicerService")
public class ServicerService {

	@Autowired
	private UserManager userManager;

	@Autowired
	private TimeQuantumManager timeQuantumManager;

	@Autowired
	private LocationManager locationManager;

	@Autowired
	private ServiceItemOwnServicerTypeManager serviceItemOwnServicerTypeManager;

	private Logger logger = LoggerFactory.getLogger(ServicerService.class);

	/**
	 * @author liushuaic
	 * @throws IOException
	 * @date 2015/10/14 19:52 获取有空闲时间的评估师
	 **/
	public Map<String, Object> getAssessmentService(Map<String, Object> paramData) {

		Map<String, Object> rtnMap = new HashMap<String, Object>();

		if (null != paramData.get("districtCode") && null != paramData.get("mapPositionAddress")
				&& null != paramData.get("detailAddress") && null != paramData.get("serviceDate")
				&& null != paramData.get("custumerTimeQuantumId")) {
			// 有空闲时间的用户
			//
			String serviceDate = paramData.get("serviceDate").toString();
			String custumerTimeQuantumId = paramData.get("custumerTimeQuantumId").toString();
			String detailAddress = paramData.get("detailAddress").toString();
			String mapPositionAddress = paramData.get("mapPositionAddress").toString();
			String districtCode = paramData.get("districtCode").toString();

			// 查询出某一天的，某一个时间段有人的，
			// TODO 后期，可以加入 推荐下个时间段 ，有空闲时间的人。
			List<UserServiceInfo> serviers = userManager.getPINGGUServicerByServiceDateCustumerQuantumId(serviceDate,
					Long.valueOf(custumerTimeQuantumId));

			// 获取目的地城市
			Location city = locationManager.getCityByDistrictCode(districtCode);

			// 获取查询出来的距离结果
			MapResponse<LinkedHashMap<String, String>> distances = null;
			
			try {
				distances = MapUtils.getOriginsDestinationDistance(getOriginsStr(serviers),
						MapUtils.getAddressPosition(mapPositionAddress, detailAddress, city.getAdministrativeCode()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error(e.getMessage());
			}

			// 获取服务人员
			UserServiceInfo server = null;
			if (null != distances && (!distances.getStatus().equals("0"))) {
				server = ServicerBusinessLogic.disposeServicer(serviers, distances);
			}

			Map<String, Object> pingGuData = null;
			// 如果现在的没有评估师，就返回一个固定的评估师
			if (null != server) {
				pingGuData = userManager.getPingGuServicerByUserId(server.getUserId());
			} else {
				pingGuData = userManager.getPingGuServicerByUserId(182l);
			}

			if (pingGuData == null) {
				rtnMap.put("status", ExceptionConstants.servicerException.servicerNoBady.errorCode);
				rtnMap.put("message", ExceptionConstants.servicerException.servicerNoBady.errorMessage);
			} else {
				rtnMap.put("data", pingGuData);
				rtnMap.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
				rtnMap.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
			}

		} else {
			rtnMap.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
			rtnMap.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		return rtnMap;
	}

	/**
	 * @author liushuaic
	 * @throws IOException
	 * @date 2015/10/14 19:52 获取有空闲时间的服务人员
	 **/
	public Map<String, Object> getServicerService(Map<String, Object> paramData) {

		Map<String, Object> rtnMap = new HashMap<String, Object>();

		if (null != paramData.get("districtCode") && null != paramData.get("mapPositionAddress")
				&& null != paramData.get("detailAddress") && null != paramData.get("serviceDate")
				&& null != paramData.get("custumerTimeQuantumId") && null != paramData.get("serviceItemId")) {
			// 有空闲时间的用户
			//
			String serviceDate = paramData.get("serviceDate").toString();
			String custumerTimeQuantumId = paramData.get("custumerTimeQuantumId").toString();
			String detailAddress = paramData.get("detailAddress").toString();
			String mapPositionAddress = paramData.get("mapPositionAddress").toString();
			String districtCode = paramData.get("districtCode").toString();
			String serviceItemId = paramData.get("serviceItemId").toString();

			// 查询出某一天的，某一个时间段有人的，
			// TODO 后期，可以加入 推荐下个时间段 ，有空闲时间的人。
			List<UserServiceInfo> serviers = userManager.getServicerByServicerItemId(serviceDate,
					Long.valueOf(custumerTimeQuantumId), Long.valueOf(serviceItemId));
			
			Map<String, Object> pingGuData = null;
			
			if (null != serviers) {

				// 获取目的地城市
				Location city = locationManager.getCityByDistrictCode(districtCode);

				// 获取查询出来的距离结果
				MapResponse<LinkedHashMap<String, String>> distances = null;

				try {
					distances = MapUtils.getOriginsDestinationDistance(getOriginsStr(serviers), MapUtils
							.getAddressPosition(mapPositionAddress, detailAddress, city.getAdministrativeCode()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					logger.error(e.getMessage());
				}

				// 获取服务人员
				UserServiceInfo server = null;
				if (null != distances && (!distances.getStatus().equals("0"))) {
					server = ServicerBusinessLogic.disposeServicer(serviers, distances);
				}

				
				// 如果现在的没有评估师，就返回一个固定的评估师
				if (null != server) {
					pingGuData = userManager.getPingGuServicerByUserId(server.getUserId());
				} else {
					pingGuData = userManager.getPingGuServicerByUserId(182l);
				}

			} else {
				pingGuData = userManager.getPingGuServicerByUserId(182l);
			}

			if (pingGuData == null) {
				rtnMap.put("status", ExceptionConstants.servicerException.servicerNoBady.errorCode);
				rtnMap.put("message", ExceptionConstants.servicerException.servicerNoBady.errorMessage);
			} else {
				rtnMap.put("data", pingGuData);
				rtnMap.put("status", ExceptionConstants.responseSuccess.responseSuccess.code);
				rtnMap.put("message", ExceptionConstants.responseSuccess.responseSuccess.message);
			}

		} else {
			rtnMap.put("status", ExceptionConstants.parameterException.parameterException.errorCode);
			rtnMap.put("message", ExceptionConstants.parameterException.parameterException.errorMessage);
		}
		return rtnMap;
	}

	public String[] getOriginsStr(List<UserServiceInfo> serviers) {

		String originsStr = "";
		String[] origins = new String[serviers.size()];

		for (int i = 0; i < serviers.size(); i++) {
			UserServiceInfo userServiceInfo = serviers.get(i);

			String lngStr = userServiceInfo.getLongitude().toString();
			String latStr = userServiceInfo.getLatitude().toString();

			originsStr = lngStr + "," + latStr;

			origins[i] = originsStr;
		}

		return origins;
	}

}
