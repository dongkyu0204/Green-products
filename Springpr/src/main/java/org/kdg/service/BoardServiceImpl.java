package org.kdg.service;

import java.util.ArrayList;

import org.kdg.domain.BoardDTO;
import org.kdg.domain.Criteria;
import org.kdg.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper bmapper;
	
	// 게시판 글쓰기 설계된 것을 구현
	public void write(BoardDTO board) {
		bmapper.write(board);
	}
	// 게시판 목록 리스트 설계된 것을 구현
	public ArrayList<BoardDTO> list(Criteria cri) {
		return bmapper.list(cri);
	}
	// 게시판 상세 페이지 설계한 것을 구현
	@Transactional
	public BoardDTO detail(BoardDTO board) {
		// board 테이블의 조회수 속성에 +1
		bmapper.cntupdate(board);
		// 상세 페이지 select
		return bmapper.detail(board);
	}
	// 게시판 글수정 설계된 것을 구현
	public void modify(BoardDTO board) {
		bmapper.modify(board);
	}
	// 게시판 글삭제 설계된 것을 구현
	public void remove(BoardDTO board) {
		bmapper.remove(board);
	}
}















