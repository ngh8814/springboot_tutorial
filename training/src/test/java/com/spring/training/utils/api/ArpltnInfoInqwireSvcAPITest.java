package com.spring.training.utils.api;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.training.dto.airkorea.CtprvnMeasureSidoDTO;
import com.spring.training.dto.airkorea.CtprvnMeasureSidoRspDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArpltnInfoInqwireSvcAPITest {

	@Autowired ArpltnInforInqireSvcAPI api;
	
	@Test
	public void url() {
		
		CtprvnMeasureSidoRspDTO dto = api.getAirPollutionInfo("서울");
		
		
		List<CtprvnMeasureSidoDTO> list = dto.getList();
		
		for (CtprvnMeasureSidoDTO eh : list) {
			System.out.println(eh.toEntity());
		}
	}
}
