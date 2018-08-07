package com.spring.training.dto.board;

import com.spring.training.domain.board.Board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BoardDTO {

	private long seq;
	private String title;
	private String content;
	private String reguser;
	private String updateuser;
	
	public Board toEntity() {
		return Board.builder()
				.seq(seq)
				.title(title)
				.content(content)
				.reguser(reguser)
				.updateuser(updateuser)
				.build();
	}
}
