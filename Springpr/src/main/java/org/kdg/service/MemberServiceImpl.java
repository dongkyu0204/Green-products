package org.kdg.service;

import org.kdg.domain.MemberDTO;
import org.kdg.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberMapper mmapper;
	
	// 회원가입 설계한 것을 구현
	public void insert(MemberDTO mdto) {
		mmapper.insert(mdto);
	}
	
	// 로그인 설계한 것을 구현
	public MemberDTO login(MemberDTO mdto) {
		return mmapper.login(mdto);
	}
}
