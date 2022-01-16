package org.kdg.mapper;

import java.util.ArrayList;

import org.kdg.domain.NewCriteriaDTO;
import org.kdg.domain.NewboardDTO;

public interface NewboardMapper {
	// 게시판 목록과 관련이 있는 DB 설계
	public ArrayList<NewboardDTO> newlist(NewCriteriaDTO cri);
	// 게시판 글쓰기와 관련 있는 DB 설계
	public void newWrite(NewboardDTO board);
	// 게시판 상세 페이지와 관련 있는 DB 설계
	public NewboardDTO newDetail(NewboardDTO board);
	//게시판 제목을 클릭했을 때 조회수 +1
	public void cntUpdate(NewboardDTO board);
	// 게시판 수정하기와 관련 있는 DB 설계
	public void newModify(NewboardDTO board);
	// 게시판 수정하기와 관련 있는 DB 설계
	public void newRemove(NewboardDTO board);
	// 게시판 페이징에 쓰일 전체 건수
	public int getTotalCount(NewCriteriaDTO cri);
}
