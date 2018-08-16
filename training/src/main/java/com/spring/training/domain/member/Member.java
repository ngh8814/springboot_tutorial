package com.spring.training.domain.member;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(of="uid")
public class Member {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false, unique=true, length=50)
	private String uid;
	
	@Column(nullable=false, length=200)
	private String upw;
	
	@Column(nullable=false, unique=true, length=50)
	private String uemail;
	
	@CreationTimestamp
	private LocalDateTime regdatetime;
	
	@UpdateTimestamp
	private LocalDateTime updatedatetime;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
	@JoinColumn(name="uid")
	private List<MemberRole> roles;
	 
	@Builder
	public Member(long id, String uid, String upw, 
			String uemail, List<MemberRole> roles) {
		this.id = id;
		this.uid = uid;
		this.upw = upw;
		this.uemail = uemail;
		this.roles = roles;
	}
	
}
