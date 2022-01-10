package org.kdg.mapper;

import java.util.ArrayList;

import org.kdg.domain.NewboardDTO;

public interface NewboardMapper {
	// 게시판 목록과 관련이 있는 DB 설계
	public ArrayList<NewboardDTO> newlist();
	// 게시판 글쓰기와 관련 있는 DB 설계
	public void newWrite(NewboardDTO board);
	// 게시판 상세 페이지와 관련 있는 DB 설계
	public void detail();
}
