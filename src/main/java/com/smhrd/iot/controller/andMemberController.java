package com.smhrd.iot.controller;

import java.awt.PageAttributes.MediaType;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smhrd.iot.domain.member_info;
import com.smhrd.iot.service.andMemberService;


@RestController
public class andMemberController {
	@Autowired
	andMemberService service;

	//@RequestMapping(value = "/loginCheckMember")
	//public String memberLogin() {
		// @RequestBody Map<String, String> params
	//	System.out.println("안드로이드 요청 들어옴");
		// JSONObject responseJson = new JSONObject();
		// responseJson.put("success", true);
		// responseJson.put("message", "로그인 성공");

		// return responseJson.toString();
	//	return null;
	//}
	private ObjectMapper objectMapper = new ObjectMapper();
	
	 @RequestMapping(value="/loginCheckMember", method=RequestMethod.POST, consumes = "application/json")
	 public ResponseEntity<Map<String, Object>> memberLogin(@RequestBody member_info m) {
		 System.out.println("데이터가 온다");
		 System.out.println(m.toString());
		  String id =m.getMember_id();
		  String pw =m.getMember_pw();
		  System.out.println(id);
		  System.out.println(pw);

		 boolean success = false;
		 
		 if(service.memberLogin(id,pw)>0) {
			 success = true; // 로그인 성공 여부
			 System.out.println("서버는 된다");
		 }else {
			 System.out.println("서버는 안된다");
		 }
		 
		  if (success) {
			  Map<String, Object> response = new HashMap<>();
	            response.put("success", true);
	            response.put("message", "로그인 성공");
	            return ResponseEntity.ok(response);
		    } else {
		    	Map<String, Object> response = new HashMap<>();
		        response.put("success", false);
		        response.put("message", "로그인 실패");
		        return ResponseEntity.ok(response);
		    }
	 } 
	 
	
	
	}



	

