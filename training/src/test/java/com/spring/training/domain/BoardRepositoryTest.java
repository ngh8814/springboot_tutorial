package com.spring.training.domain;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.training.domain.board.Board;
import com.spring.training.domain.board.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {

	@Autowired BoardRepository boardRepository;
	
	@After
	public void cleanup() {
		boardRepository.deleteAll();
	}
	
	@Test
	public void add() {
		
		LocalDateTime now = LocalDateTime.now();
		
		Board board = boardRepository.save(Board.builder()
				.title("테스트 제목")
				.content("테스트 본문")
				.reguser("테스트 등록자")
				.build());
		
		assertThat(board.getTitle(), Matchers.is("테스트 제목"));
		assertThat(board.getContent(), Matchers.is("테스트 본문"));
		assertThat(board.getReguser(), Matchers.is("테스트 등록자"));
		assertTrue(board.getRegdatetime().isAfter(now));
		assertTrue(board.getUpdatedatetime().isAfter(now));
	}
	
	@Test
	public void view() {
		Board saved = boardRepository.save(Board.builder()
				.title("테스트 제목")
				.content("테스트 본문")
				.reguser("테스트 등록자")
				.build());
		
		Optional<Board> board = boardRepository.findById(saved.getSeq());
		
		assertTrue(board.isPresent());
	}
}
