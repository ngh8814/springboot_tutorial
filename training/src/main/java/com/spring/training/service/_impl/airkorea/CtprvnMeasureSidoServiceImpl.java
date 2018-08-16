package com.spring.training.service._impl.airkorea;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.spring.training.domain.airkorea.CtprvnMeasureSido;
import com.spring.training.domain.airkorea.CtprvnMeasureSidoRepository;
import com.spring.training.dto.airkorea.CtprvnMeasureSidoDTO;
import com.spring.training.dto.airkorea.CtprvnMeasureSidoRspDTO;
import com.spring.training.service.airkorea.CtprvnMeasureSidoService;
import com.spring.training.utils.StringUtil;
import com.spring.training.utils.api.ArpltnInforInqireSvcAPI;

@Service("ctprvnMeasureSidoServiceImpl")
public class CtprvnMeasureSidoServiceImpl implements CtprvnMeasureSidoService {

	@Autowired private CtprvnMeasureSidoRepository ctprvnMeasureSidoRepository;
	@Autowired private ArpltnInforInqireSvcAPI arpltnInforInqireSvcAPI;
	@Autowired private EntityManager entityManager;
	
	@Value("${api.airkorea.ctprvn-mesure-sido.sido-names}")
	private String SIDO_NAMES;
	
	@Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")
	private int BATCH_SIZE;
	
	@Override
	@Transactional
	public void save() {
		
		String[] sidoNames = SIDO_NAMES.split(",");
		
		
		CtprvnMeasureSido data = ctprvnMeasureSidoRepository.findTopByOrderByDataTimeDesc();
		
		List<CtprvnMeasureSidoDTO> checkList = arpltnInforInqireSvcAPI.getAirPollutionInfo(sidoNames[0].trim()).getList();
		
		boolean isNew = false;
		final int BREAK_CNT = 3;
		int idx = 0;
		
		while (!isNew) {
			
			if (checkList.size() > 0) {
				
				if (data == null) {
					isNew = true;
					break;
				}
				
				LocalDateTime prev = data.getDataTime();
				LocalDateTime now = StringUtil.parseLocalDateTime(checkList.get(0).getDataTime(), "yyyy-MM-dd HH:mm");
				
				
				System.out.println("IS AFTER : [" + now.isAfter(prev) + "]   prev [" + prev.toString() + "] now [" + now.toString() + "]");
				
				if (now.isAfter(prev)) {
					isNew = true;
					break;
				} else {
					try {
						System.out.println("Wait 10 minutes....");
						
						Thread.sleep(10 * 60 * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
						continue;
					}
				}
				
				System.out.println("CALL COUNT [" + (idx + 1) + "]");
				
				if (idx > BREAK_CNT) {
					break;
				}
				
				idx++;
						
			}
			
		}
		
		if (isNew) {
		
			List<CtprvnMeasureSido> insertList = new ArrayList<>();
			
			for (String sido : sidoNames) {
				
				CtprvnMeasureSidoRspDTO dto = arpltnInforInqireSvcAPI.getAirPollutionInfo(sido.trim());
				
				insertList.addAll(dto.getEntityList());
				
			}
			
			batch(insertList);
		
		}
		
	}
	
	
	private void batch(List<CtprvnMeasureSido> insertList) {
		try {
			
			for (int i = 0; i < insertList.size(); i++) {
				
				if (i > 0 && i % BATCH_SIZE ==0) {
					entityManager.flush();
					entityManager.clear();
				}
				
				entityManager.persist(insertList.get(i));
			}
			
			entityManager.flush();
			
		} catch (Exception e) {
			throw e;
		} finally {
			entityManager.close();
		}
	}
	
}
