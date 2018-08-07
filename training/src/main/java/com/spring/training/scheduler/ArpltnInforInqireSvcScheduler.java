package com.spring.training.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.spring.training.service.airkorea.CtprvnMeasureSidoService;

@Component
public class ArpltnInforInqireSvcScheduler {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Autowired CtprvnMeasureSidoService ctprvnMeasureSidoService;
	 
	@Scheduled(cron = "0 0 * * * *")
	public void helloWorldTask() {
		System.out.println("Start Scheduler " + dateFormat.format(new Date()));
		
		ctprvnMeasureSidoService.save();
		
		System.out.println("End Scheduler " + dateFormat.format(new Date()));
	}
}
