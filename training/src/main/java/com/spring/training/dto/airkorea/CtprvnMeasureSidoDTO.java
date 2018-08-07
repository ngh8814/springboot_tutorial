package com.spring.training.dto.airkorea;

import java.time.LocalDateTime;

import com.spring.training.domain.airkorea.CtprvnMeasureSido;
import com.spring.training.utils.StringUtil;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CtprvnMeasureSidoDTO {
	
	private long seq;
	private LocalDateTime saveDatetime;
	private String cityName;
	private String cityNameEng;
	private String coValue;
	private String dataTime;
	private String districtCode;
	private String districtNumSeq;
	private String no2Value;
	private String o3Value;
	private String pm10Value;
	private String pm25Value;
	private String sidoName;
	private String so2Value;
	
	private String _returnType;
	private String pageNo;
	private String itemCode;
	private String khaiValue;
	private String numOfRows;
	private String totalCount;
	
	public CtprvnMeasureSido toEntity() {
		return CtprvnMeasureSido.builder()
				.cityName(cityName)
				.cityNameEng(cityNameEng)
				.coValue(StringUtil.parseFloat(coValue))
				.dataTime(StringUtil.parseLocalDateTime(dataTime, "yyyy-MM-dd HH:mm"))
				.districtCode(districtCode)
				.districtNumSeq(districtNumSeq)
				.no2Value(StringUtil.parseFloat(no2Value))
				.o3Value(StringUtil.parseFloat(o3Value))
				.pm10Value(StringUtil.parseInt(pm10Value))
				.pm25Value(StringUtil.parseInt(pm25Value))
				.sidoName(sidoName)
				.so2Value(StringUtil.parseFloat(so2Value))
				.build();
	}
	
	
	
	
}
