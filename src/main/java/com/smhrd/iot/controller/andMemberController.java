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

	private ObjectMapper objectMapper = new ObjectMapper();
	
	 @RequestMapping(value="/loginCheckMember", method=RequestMethod.POST, consumes = "application/json")
	 public ResponseEntity<Map<String, Object>> memberLogin(@RequestBody member_info m) {
		 
		  String id =m.getMember_id();
		  String pw =m.getMember_pw();

		 if(service.memberLogin(id,pw)>0) {
			 Map<String, Object> response = new HashMap<>();
	            response.put("success", true);
	            response.put("message", "로그인 성공");
	            return ResponseEntity.ok(response);
		 }
		 else {
		    	Map<String, Object> response = new HashMap<>();
		        response.put("success", false);
		        response.put("message", "로그인 실패");
		        return ResponseEntity.ok(response);
		    }
	 } 
	 @RequestMapping(value="/newMember", method=RequestMethod.POST, consumes = "application/json")
	 public ResponseEntity<Map<String, Object>> newMember(@RequestBody member_info m){
		System.out.println(m.toString());
		 if(service.newMember(m)>0) {
			 Map<String, Object> response = new HashMap<>();
	            response.put("success", true);
	            response.put("message", "회원가입 성공");
	            
	            return ResponseEntity.ok(response);
		 }
		 else {
		    	Map<String, Object> response = new HashMap<>();
		        response.put("fail", false);
		        response.put("message", "회원가입 실패");
		        
		        return ResponseEntity.ok(response);
		    }
	 }
	
	
	}



	

