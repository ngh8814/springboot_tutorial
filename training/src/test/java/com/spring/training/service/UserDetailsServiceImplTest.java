package com.spring.training.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailsServiceImplTest {

	@Autowired UserDetailsService userDetailsService;
	
	@Test
	public void test() {
		
		UserDetails ud = userDetailsService.loadUserByUsername("ngh8814");
		
		System.out.println(ud.getUsername());
		System.out.println(ud.getPassword());
		
	}
	
}
