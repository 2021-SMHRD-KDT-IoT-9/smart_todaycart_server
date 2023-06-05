package com.smhrd.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.iot.domain.member_info;
import com.smhrd.iot.mapper.AndMapper;

@Service
public class andMemberService {
	@Autowired
	AndMapper mapper;
	
	//안드로이드 로그인
	public int memberLogin(String id, String pw) {
		return mapper.memberLogin(id,pw);
	}
	//안드로이드 회원가입
	public int newMember(member_info m) {
		return mapper.newMember(m);
	}
	
	//안드로이드 로그인한 id 정보 가져오기
	public member_info memberInform(String id) {
		return mapper.memberInform(id);
	}
	
}
