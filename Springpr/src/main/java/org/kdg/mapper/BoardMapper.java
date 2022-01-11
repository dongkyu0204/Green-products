package org.kdg.mapper;

import java.util.ArrayList;

import org.kdg.domain.BoardDTO;
import org.kdg.domain.Criteria;

public interface BoardMapper {
	//게시판 글쓰기와 관련이 있는 DB작업에 대한 설계
	public void write(BoardDTO board);
	//게시판 목록 리스트와 관련이 있는 DB작업에 대한 설계
	public ArrayList<BoardDTO> list(Criteria cri);
	//게시판 상세페이지와 관련이 있는 DB작업 설계
	public BoardDTO detail(BoardDTO board);
	//게시판 제목을 클릭했을 때 조회수 +1
	public void cntupdate(BoardDTO board);
	//글 수정과 관련이 있는 DB작업 설계
	public void modify(BoardDTO board);
	//글 삭제와 관련이 있는 DB작업 설계
	public void remove(BoardDTO board);
	//게시판 페이징에 쓰일 전체 건수
	public int getTotalCount(Criteria cri);
}
