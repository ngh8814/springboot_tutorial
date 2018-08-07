package com.spring.training.dto.airkorea;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.spring.training.domain.airkorea.CtprvnMeasureSido;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CtprvnMeasureSidoRspDTO {

	private List<CtprvnMeasureSidoDTO> list;
	private Map<String, String> param;
	private Map<String, String> CtprvnMesureLIstVo2;
	private int totalCount;
	
	public List<CtprvnMeasureSido> getEntityList() {
		List<CtprvnMeasureSido> results = new ArrayList<>();
		if (list.size() > 0) {
			for (CtprvnMeasureSidoDTO dto : list) {
				results.add(dto.toEntity());
			}
		}
		return results;
	}
}
