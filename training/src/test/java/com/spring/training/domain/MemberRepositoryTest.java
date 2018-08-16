package com.spring.training.domain;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.training.domain.member.Member;
import com.spring.training.domain.member.MemberRepository;
import com.spring.training.domain.member.MemberRole;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class MemberRepositoryTest {

	@Autowired MemberRepository memberRepository;
	
//	@Test
//	public void insertTest() {
//		for (int i = 0; i < 100; i++) {
//			Member m = Member.builder()
//					.uid("user" + i)
//					.upw("pw" + i)
//					.uemail("email@" + i)
//					.build();
//			
//			String roleName = "";
//			
//			if(i <= 80) {
//				roleName = "BASIC";
//			}else if(i <= 90) {
//				roleName = "MANAGER";
//			}else {
//				roleName = "ADMIN";
//			}
//			
//			MemberRole role = MemberRole.builder()
//					.roleName(roleName)
//					.build();
//			
//			m.setRoles(Arrays.asList(role));
//			log.info(m.toString());
//			memberRepository.save(m);
//		}
//		
//	}
	
	@Test
	public void listTest() {
		
		List<Member> list = (List<Member>) memberRepository.findAll();
		
		for (Member m : list) {
			System.out.println(m.toString());
		}
	}
	
//	@Test
//	public void deleteTest() {
//		for (int i = 0; i < 100; i++) {
////			Optional<Member> opt = memberRepository.findByUid("user" + i);
////			if (opt.isPresent()) {
////				Member member = opt.get();
////				
////				memberRepository.deleteByUid(member.getUid());
////			}
//			
//			memberRepository.deleteByUid("user" + i);
//			
//		}
//	}
}
