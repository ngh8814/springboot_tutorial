package com.spring.training.domain.board;

import org.springframework.data.jpa.domain.Specification;

public class BoardSpecification {
	
	public static Specification<Board> titleLike(String title) {
		return (root, query, cb) -> cb.like(root.<String> get("title"), "%" + title + "%");
	}
	
	public static Specification<Board> contentLike(String content) {
		return (root, query, cb) -> cb.like(root.<String> get("content"), "%" + content + "%");
	}
}
