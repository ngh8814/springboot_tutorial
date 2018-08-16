package com.spring.training.dto.mgr;

import java.util.List;

import com.spring.training.domain.member.Member;
import com.spring.training.domain.member.MemberRole;

import lombok.Data;

@Data
public class MemberDTO {

	private long id;
	private String uid;
	private String upw;
	private String uemail;
	private List<MemberRole> roles;
	
	public Member toEntity() {
		return Member.builder()
				.id(id)
				.uid(uid)
				.upw(upw)
				.uemail(uemail)
				.roles(roles)
				.build();
	}
}
