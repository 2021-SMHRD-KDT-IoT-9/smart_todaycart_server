package com.smhrd.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.iot.domain.member_info;
import com.smhrd.iot.mapper.AndMapper;

@Service
public class memberService {
	@Autowired
	AndMapper mapper;
	
	public int memberLogin(member_info m) {
		 return mapper.memberLogin(m);
	}
	
}
