package com.smhrd.iot.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smhrd.iot.domain.before_product;
import com.smhrd.iot.domain.callList;
import com.smhrd.iot.domain.cart_info;
import com.smhrd.iot.domain.manager;
import com.smhrd.iot.domain.member_info;
import com.smhrd.iot.service.adminService;

@RestController
//관리자가 회원가입,로그인, 가입된 회원들 관리(조회, 삭제)
public class adminRestController {
	@Autowired
	adminService service;
	
	@PostMapping(value="/registerCheck", consumes = "application/json")
	public void register(@RequestBody manager m) {	
			System.out.println("시도");
			service.register(m);
	}
	@PostMapping(value="/loginCheck" , consumes = "application/json")
	public void login(@RequestBody manager m, HttpSession session) {
		int cnt = service.login(m);
		if(cnt>0) {
			System.out.println("성공");
			session.setAttribute("loginId", m.getManager_id());
		}
		else {
			//System.out.println(m.getManager_id());
		}		
	}
	@GetMapping(value="/memberList", produces = "application/json")
	public String showMember() throws JsonProcessingException{
		System.out.println("컨트롤러단이 되나");
		 List<member_info> members = service.showMember();

		    ObjectMapper objectMapper = new ObjectMapper();
		    String json = objectMapper.writeValueAsString(members);
		    return json;
	}
	@PostMapping(value="/deleteMember")
	public void deleteMember(@RequestBody Map<String, String> requestData) {
	    String memberId = requestData.get("member_ID");
	    service.deleteMember(memberId);
	    
	}
	
	//@PostMapping(value="/showCallList")
	//public String showCallList(member_info m, cart_info c, before_product b) throws JsonProcessingException{
	//	List<callList> callList = service.showCallList(m, c, b);
	//	ObjectMapper objectMapper = new ObjectMapper();
	//    String json = objectMapper.writeValueAsString(callList);
	//    return json;
	//}

}
