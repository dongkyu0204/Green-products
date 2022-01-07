package org.kdg.mapper;

import java.util.ArrayList;

import org.kdg.domain.NewboardDTO;

public interface NewboardMapper {
	// 게시판 목록과 관련이 있는 DB 설계
	public ArrayList<NewboardDTO> newlist();
}
