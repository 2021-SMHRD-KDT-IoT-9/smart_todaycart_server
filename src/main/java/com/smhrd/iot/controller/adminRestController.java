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
	
	//웹 페이지 관리자 회원가입
	@PostMapping(value="/registerCheck", consumes = "application/json")
	public void register(@RequestBody manager m) {	
			service.register(m);
	}
	//웹 페이지 회원 로그인
	@PostMapping(value="/loginCheck" , consumes = "application/json")
	public void login(@RequestBody manager m, HttpSession session) {
		int cnt = service.login(m);
		if(cnt>0) {
		
			session.setAttribute("loginId", m.getManager_id());
		}
		else {
			//System.out.println(m.getManager_id());
		}		
	}
	
	//서버에서 클라이언트로 세션값 전해주는 코드
	@GetMapping("/getSessionLoginId")
	public String getSessionLoginId(HttpSession session) {
	    String loginId = (String) session.getAttribute("loginId");
	    return loginId != null ? loginId : "";
	}
	
	//웹 페이지에서 가입한 회원들의 정보 열람
	@GetMapping(value="/memberList", produces = "application/json")
	public String showMember() throws JsonProcessingException{
		System.out.println("컨트롤러단이 되나");
		 List<member_info> members = service.showMember();

		    ObjectMapper objectMapper = new ObjectMapper();
		    String json = objectMapper.writeValueAsString(members);
		    return json;
	}
	//웹 페이지에서 가입한 회원들 정보 삭제
	@PostMapping(value="/deleteMember")
	public void deleteMember(@RequestBody Map<String, String> requestData) {
	    String memberId = requestData.get("member_ID");
	    service.deleteMember(memberId);
	    
	}
	
	//로그아웃 기능
	@PostMapping(value="/logout")
	public void logout(HttpSession session) {
		if(session.getAttribute("loginId")!=null) {
			service.logout(session);
			System.out.println("로그아웃 성공");
		}
	}

}
