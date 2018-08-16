package com.spring.training.dto.board;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;

import com.spring.training.domain.board.Board;
import com.spring.training.domain.board.BoardSpecification;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardListDTO {

	int pageno;
	int pagesize;
	int totalcount;
	
	String title;
	String content;
	
	List<Board> list;
	
	public PageRequest getPage() {
		
		int page = 0;
		int pageSize = 10;
		
		if (this.pageno > 0) {
			page = this.pageno - 1;
		}
		
		if (this.pagesize > 0) {
			pageSize = this.pagesize;
		}
		
		return PageRequest.of(page, pageSize, new Sort(Direction.DESC, "seq"));
	}
	
	public Specification<Board> getSpecification() {
		Specification<Board> spec = null;
		
		if (this.title != null && !this.title.isEmpty()) {
			spec = Specification.where(BoardSpecification.titleLike(this.title));
		}
		
		if (this.content != null && !this.content.isEmpty()) {
			spec = Specification.where(BoardSpecification.titleLike(this.title));
		}
		
		return spec;
	}
	
	public void setPage(Page<Board> page) {
		this.pageno = page.getNumber() + 1;
		this.pagesize = page.getSize();
		this.totalcount = page.getTotalPages();
	}
	
}
