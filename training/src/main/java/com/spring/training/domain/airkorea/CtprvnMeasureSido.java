package com.spring.training.domain.airkorea;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name="ctprvn_measure_sido")
@ToString
public class CtprvnMeasureSido {

	@Id
	@Column(name="seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ctprvn_measure_sido_generator")
	@SequenceGenerator(name="ctprvn_measure_sido_generator", sequenceName="ctprvn_measure_sido_seq_seq", allocationSize=1)
	private long seq;
	
	@Column(name="save_datetime", updatable=false)
	@CreationTimestamp
	private LocalDateTime saveDatetime;
	
	@Column(name="city_name", length=255, nullable=false)
	private String cityName;
	
	@Column(name="city_name_eng", length=255)
	private String cityNameEng;
	
	@Column(name="co_value", nullable=false)
	private float coValue;
	
	@Column(name="data_time", nullable=false)
	private LocalDateTime dataTime;
	
	@Column(name="district_code", length=255)
	private String districtCode;
	
	@Column(name="district_num_seq", length=255)
	private String districtNumSeq;
	
	@Column(name="no2_value", nullable=false)
	private float no2Value;
	
	@Column(name="o3_value", nullable=false)
	private float o3Value;
	
	@Column(name="pm10_value", nullable=false)
	private int pm10Value;
	
	@Column(name="pm25_value", nullable=false)
	private int pm25Value;
	
	@Column(name="sido_name", length=255)
	private String sidoName;
	
	@Column(name="so2_value", nullable=false)
	private float so2Value;
	
	@Builder
	public CtprvnMeasureSido(String cityName,
			String cityNameEng, float coValue, LocalDateTime dataTime,
			String districtCode, String districtNumSeq, float no2Value,
			float o3Value, int pm10Value, int pm25Value, String sidoName,
			float so2Value) {
		
		this.cityName = cityName;
		this.cityNameEng = cityNameEng;
		this.coValue = coValue;
		this.dataTime = dataTime;
		this.districtCode = districtCode;
		this.districtNumSeq = districtNumSeq;
		this.no2Value = no2Value;
		this.o3Value = o3Value;
		this.pm10Value = pm10Value;
		this.pm25Value = pm25Value;
		this.sidoName = sidoName;
		this.so2Value = so2Value;
		
	}
	
	
}
