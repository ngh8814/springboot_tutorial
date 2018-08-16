package com.spring.training.service._impl.mgr;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.training.domain.member.MemberRepository;
import com.spring.training.domain.member.MemberRole;
import com.spring.training.dto.mgr.MemberDTO;
import com.spring.training.service.mgr.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired MemberRepository memberRepository;
	
	@Override
	public void insert(MemberDTO dto) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		dto.setUpw(passwordEncoder.encode(dto.getUpw()));
		MemberRole role = MemberRole.builder()
				.roleName("BASIC")
				.build();
		
		dto.setRoles(Arrays.asList(role));
		
		memberRepository.save(dto.toEntity());
		
	}
	
}
