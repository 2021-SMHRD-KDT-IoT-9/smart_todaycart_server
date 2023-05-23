package com.smhrd.iot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.iot.domain.before_product;
import com.smhrd.iot.domain.callList;
import com.smhrd.iot.domain.cart_info;
import com.smhrd.iot.domain.manager;
import com.smhrd.iot.domain.member_info;
import com.smhrd.iot.mapper.AdminMapper;

@Service
public class adminService {
	@Autowired
	AdminMapper mapper;
	
	public void register(manager m) {
		mapper.register(m);
	}
	public int login(manager m) {
		return mapper.login(m);
	}
	public List<member_info> showMember(){
		return mapper.showMember();
	}
	public void deleteMember(String member_ID) {
		mapper.deleteMember(member_ID);
	}
	
	//public List<callList> showCallList(member_info m, cart_info c, before_product b){
	//	return mapper.showCallList(m, c, b);
	//}
}
