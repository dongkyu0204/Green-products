package org.kdg.mapper;

import java.util.ArrayList;

import org.kdg.domain.AttachFileDTO;

public interface AttachMapper {
	//게시판 글쓰기 할 때 파일과 관련 있는 attach 테이블에 insert
	public void insert(AttachFileDTO board);
	//게시판 상세페에지에 업로드된 이미지를 나타내기 위한 데이터list
	public ArrayList<AttachFileDTO> fileList(int bno);
}
