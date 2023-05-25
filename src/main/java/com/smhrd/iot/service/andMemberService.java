package com.smhrd.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.iot.domain.member_info;
import com.smhrd.iot.mapper.AndMapper;

@Service
public class andMemberService {
	@Autowired
	AndMapper mapper;
	
	public int memberLogin(String id, String pw) {
		return mapper.memberLogin(id,pw);
	}
	public int newMember(member_info m) {
		return mapper.newMember(m);
	}
}
