package com.spring.training.web.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.training.domain.board.Board;
import com.spring.training.dto.board.BoardDTO;
import com.spring.training.dto.board.BoardListDTO;
import com.spring.training.service.board.BoardService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/board")
public class BoardController {
	
	private BoardService boardService;

	@GetMapping("/list")
	public BoardListDTO list(BoardListDTO dto) {
		return boardService.list(dto);
	}
	
	@GetMapping("/view/{id}")
	public Board view(@PathVariable("seq") long seq) {
		return boardService.view(seq);
	}
	
	@PostMapping("/add")
	public Board add(@RequestBody BoardDTO dto) {
		return boardService.add(dto);
	}
	
	@PutMapping("/edit")
	public Board edit(BoardDTO dto) {
		return boardService.edit(dto);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("seq") long seq) {
		boardService.delete(seq);
	}
	
}
