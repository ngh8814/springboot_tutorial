package com.spring.training.service._impl.board;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.spring.training.domain.board.Board;
import com.spring.training.domain.board.BoardRepository;
import com.spring.training.dto.board.BoardDTO;
import com.spring.training.dto.board.BoardListDTO;
import com.spring.training.service.board.BoardService;

import lombok.AllArgsConstructor;

@Service("boardServiceImpl")
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	private BoardRepository boardRepository;
	
	@Override
	public BoardListDTO list(BoardListDTO dto) {
		Page<Board> page = boardRepository.findAll(dto.getSpecification(), dto.getPage());
		
		BoardListDTO obj = new BoardListDTO();
		obj.setPage(page);
		obj.setList(page.getContent());
		return obj;
	}
	
	@Override
	public Board add(BoardDTO dto) {
		System.out.println(dto.toString());
		return boardRepository.save(dto.toEntity());
	}
	
	@Override
	public Board view(long seq) {
		return boardRepository.findById(seq).get();
	}
	
	@Override
	public Board edit(BoardDTO dto) {
		return boardRepository.save(dto.toEntity());
	}
	
	@Override
	public void delete(long seq) {
		boardRepository.deleteById(seq);
	}
}
