package com.spring.training.domain.airkorea;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CtprvnMeasureSidoRepository extends JpaRepository<CtprvnMeasureSido, Long> {

	
	public CtprvnMeasureSido findTopByOrderByDataTimeDesc();
	
}
