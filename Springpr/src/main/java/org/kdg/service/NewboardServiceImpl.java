package org.kdg.service;

import java.util.ArrayList;

import org.kdg.domain.NewboardDTO;
import org.kdg.mapper.NewboardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewboardServiceImpl implements NewboardService{
	@Autowired
	private NewboardMapper nbmapper;
	
	// 게시판 목록 리스트 설계된 것을 구현
	public ArrayList<NewboardDTO> newlist() {
		return nbmapper.newlist();
	}
}