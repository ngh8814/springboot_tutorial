package com.spring.training.service;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.training.domain.board.Board;
import com.spring.training.domain.board.BoardRepository;
import com.spring.training.dto.board.BoardDTO;
import com.spring.training.dto.board.BoardListDTO;
import com.spring.training.service.board.BoardService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardServiceTest {

	@Autowired BoardService boardService;
	@Autowired BoardRepository boardRepository;
	
	private BoardDTO dto = new BoardDTO();
	
	@Before
	public void init() {
		dto.setTitle("테스트 제목");
		dto.setContent("테스트 내용");
		dto.setReguser("등록자");
	}
	
//	@After
//	public void cleanup() {
//		boardRepository.deleteAll();
//	}
	
//	@Test
//	public void add() {
//		
//		LocalDateTime dt = LocalDateTime.now();
//		
//		Board board = boardService.add(dto);
//		
//		assertThat(board.getTitle(), Matchers.is("테스트 제목"));
//		assertThat(board.getContent(), Matchers.is("테스트 내용"));
//		assertThat(board.getReguser(), Matchers.is("등록자"));
//		assertTrue(board.getRegdatetime().isAfter(dt));
//		
//		boardRepository.deleteById(board.getSeq());
//	}
//	
//	@Test
//	public void edit() {
//		
//		Board prev = boardService.add(dto);
//		
//		long seq = prev.getSeq();
//		LocalDateTime prevdt = prev.getRegdatetime();
//		
//		BoardDTO dto = new BoardDTO();
//		dto.setSeq(seq);
//		dto.setTitle("테스트 제목2");
//		dto.setContent("테스트 내용2");
//		dto.setUpdateuser("수정자");
//		
//		LocalDateTime dt = LocalDateTime.now();
//		
//		boardService.edit(dto);
//		
//		Board board = boardService.view(seq);
//		
//		assertThat(board.getTitle(), Matchers.is("테스트 제목2"));
//		assertThat(board.getContent(), Matchers.is("테스트 내용2"));
//		assertThat(board.getUpdateuser(), Matchers.is("수정자"));
//		assertTrue(board.getRegdatetime().isEqual(prevdt));
//		assertTrue(board.getUpdatedatetime().isAfter(dt));
//		
//		boardRepository.deleteById(board.getSeq());
//	}
//	
//	@Test
//	public void delete() {
//		
//		BoardListDTO listDTO = new BoardListDTO();
//		listDTO.setPageno(1);
//		listDTO.setPagesize(10);
//		
//		List<Board> prList = boardService.list(listDTO);
//		
//		Board prev = boardService.add(dto);
//		
//		long seq = prev.getSeq();
//		
//		boardService.delete(seq);
//		
//		
//		List<Board> afList = boardService.list(listDTO);
//		
//		assertTrue(prList.size() == afList.size());
//		
//	}
	
	@Test
	public void list() {
		
		BoardListDTO dto = new BoardListDTO();
		dto.setPageno(1);
		dto.setPagesize(10);
		dto.setTitle("테스트");
		
		BoardListDTO listDTO = boardService.list(dto);
		
		for (Board b : listDTO.getList()) {
			System.out.println(b.toString());
		}
		
		assertTrue(listDTO.getList().size() > 0);
		
	}
}
