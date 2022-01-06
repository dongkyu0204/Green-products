package org.kdg.mapper;

import java.util.ArrayList;

import org.kdg.domain.BoardDTO;

public interface BoardMapper {
	//게시판 글쓰기와 관련이 되어 있는 DB작업에 대한 설계
	public void write(BoardDTO board);
	//게시판 목록 리스트와 관련이 되어 있는 DB작업에 대한 설계
	public ArrayList<BoardDTO> list();
	//게시판 상세페이지와 관련이 되어 있는 DB작업 설계
	public BoardDTO detail(BoardDTO board);
}
