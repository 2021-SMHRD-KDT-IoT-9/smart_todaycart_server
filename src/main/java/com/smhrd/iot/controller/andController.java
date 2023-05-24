package com.smhrd.iot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.iot.domain.member_info;
import com.smhrd.iot.service.memberService;

@RestController
public class andController {
	@Autowired 
	memberService service;
	
	@PostMapping(value="/loginCheckMember")
	public String memberLogin(HttpServletRequest request) {
			System.out.println(request.getParameter("MEMBER_ID"));
			return "";
			
		}
	}



	

