package org.kdg.service;

import java.util.ArrayList;

import org.kdg.domain.NewboardDTO;

public interface NewboardService {
	// 게시판 목록 리스트 설계
	public ArrayList<NewboardDTO> newlist();
}
