package com.spring.training.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.training.service.airkorea.CtprvnMeasureSidoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CtprvnMeasureSidoServiceTest {

	@Autowired private CtprvnMeasureSidoService ctprvnMeasureSidoService;
	
	@Test
	public void save() {
		
		ctprvnMeasureSidoService.save();
		
	}
}
