package org.kdg.mapper;

import org.kdg.domain.MemberDTO;

public interface MemberMapper {
	// 회원가입 설계
	public void insert(MemberDTO mdto);
	// 로그인 설계
	public MemberDTO login(MemberDTO mdto);
}
