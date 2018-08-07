package com.spring.training.domain.airkorea;

import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.Specification;

public class CtprvnMeasureSidoSpecification {
	
	public static Specification<CtprvnMeasureSido> dataTimeEq(LocalDateTime dataTime) {
		return (root, query, cb) -> cb.equal(root.<String> get("dataTime"), dataTime.toString());
	}
	
}
