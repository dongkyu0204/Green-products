package org.kdg.service;

import java.util.ArrayList;

import org.kdg.domain.NewCriteriaDTO;
import org.kdg.domain.NewboardDTO;
import org.kdg.mapper.NewboardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NewboardServiceImpl implements NewboardService{
	@Autowired
	private NewboardMapper nbmapper;
	
	// 게시판 목록 리스트 설계된 것을 구현
	public ArrayList<NewboardDTO> newlist(NewCriteriaDTO cri) {
		return nbmapper.newlist(cri);
	}
	// 게시판 글쓰기 설계된 것을 구현
	public void newWrite(NewboardDTO board) {
		nbmapper.newWrite(board);
	}
	// 게시판 상세 페이지 설계된 것을 구현
	@Transactional
	public NewboardDTO newDetail(NewboardDTO board) {
		nbmapper.cntUpdate(board);
		return nbmapper.newDetail(board);
	}
	// 게시판 수정하기 설계한 것을 구현
	public void newModify(NewboardDTO board) {
		nbmapper.newModify(board);
	}
	// 게시판 삭제하기 설계한 것을 구현
	public void newRemove(NewboardDTO board) {
		nbmapper.newRemove(board);
	}
	// 게시판 페이징에 쓰일 전체 건수
	public int getTotalCount(NewCriteriaDTO cri) {
		return nbmapper.getTotalCount(cri);
	};
}







