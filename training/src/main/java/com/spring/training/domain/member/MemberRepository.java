package com.spring.training.domain.member;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {

	public void deleteByUid(String uid);
	
	public Optional<Member> findByUid(String uid);
}
