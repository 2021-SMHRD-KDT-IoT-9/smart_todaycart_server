package com.smhrd.iot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.smhrd.iot.domain.before_product;
import com.smhrd.iot.domain.callList;
import com.smhrd.iot.domain.cart_info;
import com.smhrd.iot.domain.manager;
import com.smhrd.iot.domain.member_info;

@Mapper
public interface AdminMapper {
	
	public void register(manager m);
	
	public int login(manager m);
	
	public List<member_info> showMember();
	
	public void deleteMember(String member_ID);
	
	//public List<callList> showCallList(member_info m, cart_info c, before_product b);
}
