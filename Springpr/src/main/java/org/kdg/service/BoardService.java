package org.kdg.service;

import java.util.ArrayList;

import org.kdg.domain.AttachFileDTO;
import org.kdg.domain.BoardDTO;
import org.kdg.domain.Criteria;

public interface BoardService {
	// 게시판 글쓰기 설계
	public void write(BoardDTO board);
	// 게시판 목록 리스트 설계
	public ArrayList<BoardDTO> list(Criteria cri);
	// 게시판 상세 페이지 설계
	public BoardDTO detail(BoardDTO board);
	// 게시판 수정 페이지
	public void modify(BoardDTO board);
	// 게시판 삭제 페이지
	public void remove(BoardDTO board);
	// 게시판 페이징에 쓰일 데이터 건수
	public int getTotalCount(Criteria cri);
	// 게시판 상세 페이지에 파일 업로드된 이미지 출력
	public ArrayList<AttachFileDTO> fileList(int bno);
}
