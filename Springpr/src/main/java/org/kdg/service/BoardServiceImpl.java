package org.kdg.service;

import java.util.ArrayList;

import org.kdg.domain.BoardDTO;
import org.kdg.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper bmapper;
	
	// 게시판 글쓰기 설계된 것을 구현
	public void write(BoardDTO board) {
		bmapper.write(board);
	}
	// 게시판 목록 리스트 설계된 것을 구현
	public ArrayList<BoardDTO> list() {
		return bmapper.list();
	}
	// 게시판 상세 페이지 설계한 것을 구현
	public BoardDTO detail(BoardDTO board) {
		return bmapper.detail(board);
	}
}
