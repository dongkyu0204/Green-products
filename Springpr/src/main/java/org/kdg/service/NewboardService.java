package org.kdg.service;

import java.util.ArrayList;

import org.kdg.domain.NewboardDTO;

public interface NewboardService {
	// 게시판 목록 리스트 설계
	public ArrayList<NewboardDTO> newlist();
	// 게시판 글쓰기 설계
	public void newWrite(NewboardDTO board);
	// 게시판 상세 페이지 설계
	public NewboardDTO newDetail(NewboardDTO board);
	// 게시판 수정하기 설계
	public void newModify(NewboardDTO board);
	// 게시판 삭제하기 설계
	public void newRemove(NewboardDTO board);
}
