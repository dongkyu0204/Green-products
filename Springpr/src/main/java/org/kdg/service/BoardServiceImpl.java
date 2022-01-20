package org.kdg.service;

import java.util.ArrayList;

import org.kdg.domain.AttachFileDTO;
import org.kdg.domain.BoardDTO;
import org.kdg.domain.Criteria;
import org.kdg.mapper.AttachMapper;
import org.kdg.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper bmapper;
	
	@Autowired
	private AttachMapper amapper;
	
	// 게시판 글쓰기 설계된 것을 구현
	@Transactional	// 내용이 입력되지 않는 경우, file도 업로드 되지 못하도록 트랜잭션
	public void write(BoardDTO board) {
		// 제목과 내용을 board 테이블에 insert
//		bmapper.write(board);
		bmapper.insertSelectKey(board);
		// 파일명, 파일경로, 파일 타입, uuid 값을 attach 테이블에 insert
		// boardDTO에 있는 attachList를 가져와서 반복문으로 실행하고 attach 변수에 저장
		board.getAttachList().forEach(attach->{
			// BoardDTO의 bno값을 가져와서 attachFileDTO의 bno에 담아줌
			attach.setBno(board.getBno());
//			System.out.println("attach bno : " + attach.getBno());
			amapper.insert(attach);
		});
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
	// 게시판 페이징에 쓰일 데이터 건수
	public int getTotalCount(Criteria cri) {
		return bmapper.getTotalCount(cri);
	}
	// 게시판 상세 페이지에 파일 업로드된 이미지 출력
	public ArrayList<AttachFileDTO> fileList(int bno) {
		return amapper.fileList(bno);
	}
}















