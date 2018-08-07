package com.spring.training.domain.board;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name="board")
@ToString
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long seq;
	
	@Column(nullable = false)
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	@Column(updatable=false)
	private String reguser;
	
	@Column(updatable=false)
	@CreationTimestamp
	private LocalDateTime regdatetime;
	
	@Column
	private String updateuser;
	
	@UpdateTimestamp
	private LocalDateTime updatedatetime;
	
	@Builder
	public Board(long seq, String title, String content, 
			String reguser,
			String updateuser) {
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.reguser = reguser;
		this.updateuser = updateuser;
	}

}
