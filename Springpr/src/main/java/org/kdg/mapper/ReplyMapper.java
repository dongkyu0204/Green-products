package org.kdg.mapper;

import java.util.ArrayList;

import org.kdg.domain.ReplyDTO;

public interface ReplyMapper {
	// 댓글 쓰기 설계
	// insert 성공 시 ReplyMapper.xml로 부터 1,
	// insert 실패 시 ReplyMapper.xml로 부터 0
	// 값을 리턴 받는다.
	public int write(ReplyDTO rdto);
	public ArrayList<ReplyDTO> list(int bno);
	public ReplyDTO detail(int rno);
}
