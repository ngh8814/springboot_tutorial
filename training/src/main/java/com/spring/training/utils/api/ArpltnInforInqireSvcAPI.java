package com.spring.training.utils.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.spring.training.dto.airkorea.CtprvnMeasureSidoRspDTO;
import com.spring.training.utils.UrlUtil;

@Component("arpltnInforInqireSvcAPI")
public class ArpltnInforInqireSvcAPI {
	
	@Value("${api.airkorea.base-url}")
	private String BASE_URL;
	
	@Value("${api.airkorea.service-key}")
	private String SERVICE_KEY;
	
	
	
	@Value("${api.airkorea.ctprvn-mesure-sido.url-path}")
	private String CMS_PATH;
	
	@Value("${api.airkorea.ctprvn-mesure-sido.sido-names}")
	private String CMS_SIDO;
	
	@Value("${api.airkorea.ctprvn-mesure-sido.search-condition}")
	private String CMS_CONDITION;
	
	@Value("${api.airkorea.ctprvn-mesure-sido.num-of-rows}")
	private String CMS_ROWS;
	
	@Value("${api.airkorea.ctprvn-mesure-sido.return-type}")
	private String CMS_TYPE;
	
	public CtprvnMeasureSidoRspDTO getAirPollutionInfo(String sidoName) {
		
		Map<String, String> param = new HashMap<>();
		
		param.put("ServiceKey", SERVICE_KEY);
		param.put("numOfRows", CMS_ROWS);
		param.put("sidoName", sidoName);
		param.put("searchCondition", CMS_CONDITION);
		param.put("_returnType", CMS_TYPE);
		
		
		StringBuilder ub = new StringBuilder();
		
		ub.append(BASE_URL)
			.append(CMS_PATH)
			.append(UrlUtil.makeParam(param, "ServiceKey".split(",")));
		
		
		String respMsg = UrlUtil.connectHttp(ub.toString(), "GET");
		
		Gson gson = new Gson();
		
		return gson.fromJson(respMsg, CtprvnMeasureSidoRspDTO.class);
	}
	
}
