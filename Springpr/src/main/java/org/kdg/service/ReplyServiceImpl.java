package org.kdg.service;

import org.kdg.domain.ReplyDTO;
import org.kdg.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	private ReplyMapper rmapper;
	
	// 댓글 쓰기 설계한 것을 구현
	public void write(ReplyDTO rdto) {
		rmapper.write(rdto);
	}
}
