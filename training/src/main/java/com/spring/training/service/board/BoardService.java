package com.spring.training.service.board;

import com.spring.training.domain.board.Board;
import com.spring.training.dto.board.BoardDTO;
import com.spring.training.dto.board.BoardListDTO;

public interface BoardService {

	BoardListDTO list(BoardListDTO dto);

	Board add(BoardDTO dto);

	Board view(long seq);

	Board edit(BoardDTO dto);

	void delete(long seq);

}
