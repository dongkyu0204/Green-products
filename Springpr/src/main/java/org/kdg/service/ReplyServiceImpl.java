package org.kdg.service;

import java.util.ArrayList;

import org.kdg.domain.ReplyDTO;
import org.kdg.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	private ReplyMapper rmapper;
	
	// 댓글 쓰기 설계한 것을 구현
	public int write(ReplyDTO rdto) {
		// insert 성공 시 ReplyMapper.java로 부터 1,
		// insert 실패 시 ReplyMapper.java로 부터 0
		// 값을 리턴 받는다.
		return rmapper.write(rdto);
	}
	
	// 댓글 목록 리스트 설계한 것을 구현
	public ArrayList<ReplyDTO> list(int bno) {
		return rmapper.list(bno);
	}
	
	// 댓글 수정을 하기 위해 댓글 내용 가져오기
	public ReplyDTO detail(int rno) {
		return rmapper.detail(rno);
	}
}
