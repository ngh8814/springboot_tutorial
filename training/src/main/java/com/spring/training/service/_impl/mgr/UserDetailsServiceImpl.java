package com.spring.training.service._impl.mgr;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.training.domain.member.MemberRepository;
import com.spring.training.domain.member.SecurityMember;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return Optional.ofNullable(memberRepository.findByUid(username))
				.filter(m -> m != null)
				.map(m -> new SecurityMember(m.get()))
				.get();
	}
	
	
	
	
}
