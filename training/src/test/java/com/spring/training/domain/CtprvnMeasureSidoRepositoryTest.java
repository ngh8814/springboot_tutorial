package com.spring.training.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.training.domain.airkorea.CtprvnMeasureSido;
import com.spring.training.domain.airkorea.CtprvnMeasureSidoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CtprvnMeasureSidoRepositoryTest {

	@Autowired private CtprvnMeasureSidoRepository ctprvnMeasureSidoRepository;
	
	@Test
	public void maxTest() {
		
		CtprvnMeasureSido data = ctprvnMeasureSidoRepository.findTopByOrderByDataTimeDesc();
		System.out.println(data.toString());
	}
	
}
